package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.dtos.request.AddOrderRequest;
import africa.semicolon.ewaApp.data.dtos.response.AddOrderResponse;
import africa.semicolon.ewaApp.data.models.Order;
import africa.semicolon.ewaApp.data.repositories.OrderRepository;
import africa.semicolon.ewaApp.data.repositories.OrderRepositoryImpl;
import africa.semicolon.ewaApp.utils.ModelMapper;

import java.util.List;

public class OrderServicesImpl implements OrderServices{
    private final static OrderRepository orderRepository = new OrderRepositoryImpl();
    @Override
    public AddOrderResponse addOrder(AddOrderRequest addOrderRequest) {

        Order order = ModelMapper.map(addOrderRequest);

        Order savedOrder = orderRepository.save(order);

        return ModelMapper.map(savedOrder);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAllOrders();
    }
}
