package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.dtos.request.RegisterCustomerRequest;
import africa.semicolon.ewaApp.data.dtos.response.RegisterCustomerResponse;

public interface CustomerServices {

    RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest);
}
