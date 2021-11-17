package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.dtos.request.RegisterCustomerRequest;
import africa.semicolon.ewaApp.data.dtos.response.RegisterCustomerResponse;
import africa.semicolon.ewaApp.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServicesImplTest {

    private static CustomerServices customerServices;

    @BeforeEach
    void setUp() {
        customerServices = new CustomerServicesImpl();
    }

    @AfterEach
    void tearDown() {
        customerServices.deleteAllCustomers();
    }

    @Test
    void registerCustomer() {

        RegisterCustomerRequest registerCustomerRequest = new RegisterCustomerRequest();
        registerCustomerRequest.setFirstName("Goodnews");
        registerCustomerRequest.setLastName("Moses");
        registerCustomerRequest.setPhoneNumber("08164759356");
        registerCustomerRequest.setUserName("goodboyz");
        registerCustomerRequest.setEmail("ukaegbugoodnews18@gmail.com");
        registerCustomerRequest.setPassword("456ugc");

        RegisterCustomerResponse response = customerServices.registerCustomer(registerCustomerRequest);

        assertEquals(1, customerServices.findAllCustomers().size());
    }

    public RegisterCustomerResponse registerASender(){

        RegisterCustomerRequest registerCustomerRequest = new RegisterCustomerRequest();
        registerCustomerRequest.setFirstName("Goodnews");
        registerCustomerRequest.setLastName("Moses");
        registerCustomerRequest.setPhoneNumber("08164759356");
        registerCustomerRequest.setUserName("goodboyz");
        registerCustomerRequest.setEmail("ukaegbugoodnews14@gmail.com");
        registerCustomerRequest.setPassword("456ugc");
        return customerServices.registerCustomer(registerCustomerRequest);
    }

    @Test
    void findCustomerByEmail(){

        RegisterCustomerResponse registeredCustomer = registerASender();

        assertEquals(registeredCustomer, customerServices.findCustomerByEmail(registeredCustomer.getEmail()).get());
    }

    @Test
    void deleteAllCustomers(){

        registerASender();
        customerServices.deleteAllCustomers();
        assertEquals(0, customerServices.findAllCustomers().size());
    }
}