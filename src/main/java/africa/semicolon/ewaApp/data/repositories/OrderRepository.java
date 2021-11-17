package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Order save (Order order);
    Optional<Order>findOrderById(Integer orderId);
    List<Order>findAllOrders();
    void deleteOrderById(Integer orderId);
    void delete(Order order);
    void deleteAll();
}
