package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.dtos.request.RegisterCustomerRequest;
import africa.semicolon.ewaApp.data.dtos.response.RegisterCustomerResponse;
import africa.semicolon.ewaApp.data.models.Customer;
import africa.semicolon.ewaApp.data.repositories.CustomerRepository;
import africa.semicolon.ewaApp.data.repositories.CustomerRepositoryImpl;
import africa.semicolon.ewaApp.exceptions.DuplicateCustomerException;
import africa.semicolon.ewaApp.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class CustomerServicesImpl implements CustomerServices{

    private final static CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest) {

        Customer savedCustomerInDb = customerRepository.findCustomerById(registerCustomerRequest.getEmail());
        if (savedCustomerInDb != null) throw new DuplicateCustomerException(registerCustomerRequest.getEmail()+ "already exist") ;
        Customer customer = ModelMapper.map(registerCustomerRequest);

        Customer savedCustomer = customerRepository.save(customer);

        return ModelMapper.map(savedCustomer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerByEmail(String email) {

        return customerRepository.findCustomerById(email);
    }

    @Override
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }

}
