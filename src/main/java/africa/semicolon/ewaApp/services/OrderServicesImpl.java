package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.dtos.request.AddOrderRequest;
import africa.semicolon.ewaApp.data.dtos.response.AddOrderResponse;
import africa.semicolon.ewaApp.data.models.Customer;
import africa.semicolon.ewaApp.data.models.Order;
import africa.semicolon.ewaApp.data.repositories.OrderRepository;
import africa.semicolon.ewaApp.data.repositories.OrderRepositoryImpl;
import africa.semicolon.ewaApp.exceptions.CustomerDoesNotExistException;
import africa.semicolon.ewaApp.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class OrderServicesImpl implements OrderServices{
    private final static OrderRepository orderRepository = new OrderRepositoryImpl();
    private final CustomerServices customerServices = new CustomerServicesImpl();
    @Override
    public AddOrderResponse addOrder(AddOrderRequest addOrderRequest){

        Optional<Customer> CustomerOptional = customerServices.findCustomerByEmail(addOrderRequest.getCustomerEmail());
        if (CustomerOptional.isEmpty()) throw  new CustomerDoesNotExistException("Customer not Registered");
        Order order = ModelMapper.map(addOrderRequest);

        Order savedOrder = orderRepository.save(order);

        return ModelMapper.map(savedOrder);
    }

    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAllOrders();
    }

    @Override
    public Optional<Order> findOrderById(Integer orderId) {
        return orderRepository.findOrderById(orderId);
    }

}
