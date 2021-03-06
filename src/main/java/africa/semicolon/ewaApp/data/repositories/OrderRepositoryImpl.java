package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Order;

import java.util.*;

public class OrderRepositoryImpl implements OrderRepository{

    private static Map<Integer, Order>database = new HashMap<>();
    @Override
    public Order save(Order order) {

        Integer id = null;
        if (order.getId() == null){
            id = database.size() + 1;
            order.setId(id);
        }
        id = order.getId();
        database.put(id, order);
        return database.get(id);
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return database.get(orderId);
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order>orders = new ArrayList<>();
        Set<Integer>keysInDb = database.keySet();
        for(Integer key : keysInDb){
            orders.add(database.get(key));
        }
        return orders;
    }

    @Override
    public void deleteOrderById(Integer orderId) {
        database.remove(orderId);
    }

    @Override
    public void delete(Order order) {
        database.remove(order.getId());
    }

    @Override
    public void deleteAll() {
        database.clear();
    }
}
