package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.dtos.request.AddOrderRequest;
import africa.semicolon.ewaApp.data.dtos.response.AddOrderResponse;
import africa.semicolon.ewaApp.data.models.Order;

import java.util.Collection;
import java.util.List;

public interface OrderServices {

    AddOrderResponse addOrder(AddOrderRequest addOrderRequest);

    List<Order> getAllOrders();
}
