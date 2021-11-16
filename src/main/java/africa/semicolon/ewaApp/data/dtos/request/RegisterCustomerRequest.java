package africa.semicolon.ewaApp.data.dtos.request;

import lombok.Data;

@Data
public class RegisterCustomerRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String userName;
}
