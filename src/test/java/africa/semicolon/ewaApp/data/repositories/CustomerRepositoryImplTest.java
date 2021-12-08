package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryImplTest {
    CustomerRepository customerRepository;
    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        customerRepository = null;
    }

    @Test
    void save() {
        Customer customer = new Customer();
        customer.setFirstName("Goodnews");
        customer.setLastName("Moses");
        customer.setPhoneNumber("08100841167");
        customer.setUserName("goodboyz");
        customer.setEmail("ukaegbugoodnews14@gmail.com");

        Customer savedCustomer = customerRepository.save(customer);

        assertEquals(savedCustomer, customerRepository.save(customer));
        assertEquals(1, customerRepository.findAll().size());
    }

    public Customer customerTestCase(){
        Customer customer = new Customer();
        customer.setFirstName("Goodnews");
        customer.setLastName("Moses");
        customer.setPhoneNumber("08100841167");
        customer.setUserName("goodboyz");
        customer.setEmail("ukaegbugoodnews14@gmail.com");

        return customerRepository.save(customer);
    }

    @Test
    void findCustomerById() {
        Customer savedCustomer =customerTestCase();

        assertEquals(savedCustomer, customerRepository.findCustomerById(savedCustomer.getEmail()));
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteCustomerById() {
        Customer savedCustomer = customerTestCase();
        customerRepository.deleteCustomerById(savedCustomer.getEmail());
        assertEquals(0, customerRepository.findAll().size());
    }

    @Test
    void delete() {
        Customer savedCustomer = customerTestCase();
        customerRepository.delete(savedCustomer);
        assertEquals(0, customerRepository.findAll().size());
    }
}