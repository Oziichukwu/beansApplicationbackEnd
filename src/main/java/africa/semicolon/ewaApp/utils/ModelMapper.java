package africa.semicolon.ewaApp.utils;

import africa.semicolon.ewaApp.data.dtos.request.AddOrderRequest;
import africa.semicolon.ewaApp.data.dtos.request.RegisterCustomerRequest;
import africa.semicolon.ewaApp.data.dtos.response.AddOrderResponse;
import africa.semicolon.ewaApp.data.dtos.response.RegisterCustomerResponse;
import africa.semicolon.ewaApp.data.models.Customer;
import africa.semicolon.ewaApp.data.models.Order;

public class ModelMapper {

    public static Customer map(RegisterCustomerRequest registerCustomerRequest){

        Customer customer = new Customer();

        customer.setFirstName(registerCustomerRequest.getFirstName());
        customer.setLastName(registerCustomerRequest.getLastName());
        customer.setPhoneNumber(registerCustomerRequest.getPhoneNumber());
        customer.setUserName(registerCustomerRequest.getUserName());
        customer.setEmail(registerCustomerRequest.getEmail());
        customer.setPassword(registerCustomerRequest.getPassword());
        return customer;
    }

    public static RegisterCustomerResponse map(Customer savedCustomer){

        RegisterCustomerResponse response = new RegisterCustomerResponse();

        response.setUserName(savedCustomer.getUserName());
        response.setEmail(savedCustomer.getEmail());
        return response;
    }

    public static Order map(AddOrderRequest addOrderRequest){

        Order order = new Order();
        order.setBeansType(addOrderRequest.getBeansType());
        order.setReceiverName(addOrderRequest.getReceiverName());
        order.setDeliveryAddress(addOrderRequest.getDeliveryAddress());

        return order;
    }

    public static AddOrderResponse map(Order savedOrder){

        AddOrderResponse response = new AddOrderResponse();

        response.setTrackingid(savedOrder.getId());
        response.setReceiverName(savedOrder.getReceiverName());
        response.setDeliveryAddress(savedOrder.getDeliveryAddress());
        response.setBeansType(savedOrder.getBeansType());

        return response;
    }
}
