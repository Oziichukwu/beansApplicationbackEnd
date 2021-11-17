package africa.semicolon.ewaApp.controller;

import africa.semicolon.ewaApp.data.dtos.request.AddOrderRequest;
import africa.semicolon.ewaApp.data.dtos.response.AddOrderResponse;
import africa.semicolon.ewaApp.data.models.Order;
import africa.semicolon.ewaApp.exceptions.CustomerDoesNotExistException;
import africa.semicolon.ewaApp.services.OrderServices;
import africa.semicolon.ewaApp.services.OrderServicesImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {

    private final OrderServices orderServices = new OrderServicesImpl();
    @PostMapping("/api/addOrder")
    public ResponseEntity<?> addOrder(@RequestBody AddOrderRequest addOrderRequest){

        try {
            AddOrderResponse response = orderServices.addOrder(addOrderRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (CustomerDoesNotExistException ex){
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/order/{id}")
    public Optional<Order>findByOrderId(@PathVariable ("id")Integer id){
        return orderServices.findOrderById(id);
    }
}
