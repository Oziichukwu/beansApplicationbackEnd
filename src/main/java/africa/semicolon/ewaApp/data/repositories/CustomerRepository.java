package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Customer save (Customer customer);
    Optional<Customer> findCustomerById(String email);
    List<Customer>findAll();
    void deleteCustomerById(String email);
    void delete(Customer customer);

    void deleteAll();
}
