package africa.semicolon.ewaApp.controller;

import africa.semicolon.ewaApp.data.dtos.request.RegisterCustomerRequest;
import africa.semicolon.ewaApp.data.dtos.response.RegisterCustomerResponse;
import africa.semicolon.ewaApp.data.models.Customer;
import africa.semicolon.ewaApp.services.CustomerServices;
import africa.semicolon.ewaApp.services.CustomerServicesImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerServices customerServices = new CustomerServicesImpl();

    @PostMapping("/api/v1/customer")
    public RegisterCustomerResponse registerCustomer(@RequestBody RegisterCustomerRequest registerCustomerRequest){
        return customerServices.registerCustomer(registerCustomerRequest);
    }

    @GetMapping("/api/customer/{email}")
    public Optional<Customer> findCustomerById( @PathVariable String email){
        return customerServices.findCustomerByEmail(email);
    }
}
