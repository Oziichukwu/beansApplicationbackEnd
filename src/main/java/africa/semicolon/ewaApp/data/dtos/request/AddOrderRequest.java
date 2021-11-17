package africa.semicolon.ewaApp.data.dtos.request;

import lombok.Data;

@Data
public class AddOrderRequest {
    private String beansType;
    private String receiverName;
    private String deliveryAddress;
    private String receiversPhone;
}
