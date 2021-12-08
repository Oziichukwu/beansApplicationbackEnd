package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryImplTest {

    OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Order placeOrder = new Order();
        placeOrder.setBeansType("Sauced beans with pap");
        placeOrder.setId(placeOrder.getId());
        placeOrder.setReceiverName("Goodnews");
        placeOrder.setDeliveryAddress("kano state");
        placeOrder.setReceiversPhone("0899966666");

        Order savedOrder = orderRepository.save(placeOrder);

        assertEquals(savedOrder, orderRepository.save(savedOrder));
        assertEquals(1, orderRepository.findAllOrders().size());
    }

    public Order placeOrderInfo(){
        Order placeOrder = new Order();
        placeOrder.setBeansType("Sauced beans with pap");
        placeOrder.setId(placeOrder.getId());
        placeOrder.setReceiverName("Goodnews");
        placeOrder.setDeliveryAddress("kano state");
        placeOrder.setReceiversPhone("0899966666");

        return orderRepository.save(placeOrder);
    }

    @Test
    void findOrderById() {
        Order savedOrder = placeOrderInfo();
        assertEquals(savedOrder, orderRepository.findOrderById(savedOrder.getId()));
    }

    @Test
    void findAllOrders() {
    }

    @Test
    void deleteOrderById() {
        Order savedOrder = placeOrderInfo();
        orderRepository.deleteOrderById(savedOrder.getId());
        assertEquals(0, orderRepository.findAllOrders().size());
    }

    @Test
    void delete() {
        Order savedOrder = placeOrderInfo();
        orderRepository.delete(savedOrder);
        assertEquals(0, orderRepository.findAllOrders().size());

    }
}