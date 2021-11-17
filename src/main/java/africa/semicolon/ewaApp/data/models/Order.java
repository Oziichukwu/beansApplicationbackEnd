package africa.semicolon.ewaApp.data.models;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String beansType;
    private String receiverName;
    private String deliveryAddress;
    private String receiversPhone;
    private String customerEmail;
}
