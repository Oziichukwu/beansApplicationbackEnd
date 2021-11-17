package africa.semicolon.ewaApp.data.dtos.response;

import lombok.Data;

@Data
public class AddOrderResponse {
    private Integer trackingid;
    private String beansType;
    private String receiverName;
    private String deliveryAddress;
}
