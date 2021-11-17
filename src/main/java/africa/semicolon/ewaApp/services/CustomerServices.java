package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.dtos.request.RegisterCustomerRequest;
import africa.semicolon.ewaApp.data.dtos.response.RegisterCustomerResponse;
import africa.semicolon.ewaApp.data.models.Customer;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CustomerServices {

    RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest);

    List<Customer> findAllCustomers();

    Optional<Customer> findCustomerByEmail(String email);

    void deleteAllCustomers();
}
