package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Customer;

import java.util.*;

public class CustomerRepositoryImpl implements CustomerRepository{

    Map<String, Customer> database = new HashMap<>();

    @Override
    public Customer save(Customer customer) {
        database.put(customer.getEmail() , customer);
        return customer;
    }

    @Override
    public Optional<Customer> findCustomerById(String email) {
        if (database.containsKey(email)) return Optional.of(database.get(email));
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        List<Customer>customers = new ArrayList<>();
        Set<String>keysInDb = database.keySet();
        for(String key : keysInDb){
            customers.add(database.get(key));
        }
        return customers;
    }

    @Override
    public void deleteCustomerById(String email) {
        database.remove(email);
    }

    @Override
    public void delete(Customer customer) {
        database.remove(customer.getEmail());
    }

    @Override
    public void deleteAll() {
        database.clear();
    }
}
