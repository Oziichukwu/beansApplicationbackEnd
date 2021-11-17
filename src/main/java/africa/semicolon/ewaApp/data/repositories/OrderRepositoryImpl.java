package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Order;

import java.util.*;

public class OrderRepositoryImpl implements OrderRepository{

    private static Map<Integer, Order>database = new HashMap<>();
    @Override
    public Order save(Order order) {
        database.put(order.getId(), order);
        return order;
    }

    @Override
    public Optional<Order> findOrderById(Integer orderId) {
        if (database.containsKey(orderId)) return Optional.of(database.get(orderId));
        return Optional.empty();
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
