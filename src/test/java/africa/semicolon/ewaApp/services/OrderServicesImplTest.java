package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.dtos.request.AddOrderRequest;
import africa.semicolon.ewaApp.data.dtos.response.AddOrderResponse;
import africa.semicolon.ewaApp.data.models.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServicesImplTest {

    OrderServices orderServices;
    @BeforeEach
    void setUp() {
        orderServices = new OrderServicesImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addOrder() {
        AddOrderRequest addOrderRequest = new AddOrderRequest();

        addOrderRequest.setReceiverName("bolu");
        addOrderRequest.setReceiversPhone("99966688");
        addOrderRequest.setBeansType("sauced beans");
        addOrderRequest.setDeliveryAddress("yaba");

        AddOrderResponse response = orderServices.addOrder(addOrderRequest);

        assertEquals(1, orderServices.getAllOrders().size());
    }
}