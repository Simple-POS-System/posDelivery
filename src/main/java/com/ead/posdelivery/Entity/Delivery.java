package com.ead.posdelivery.Entity;

import com.ead.posdelivery.Enum.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "delivery")
public class Delivery {
    @Id
    private String deliveryId;
    private String deliveryPersonId;
    private String customerId;
    private String deliveryAddress;
    private DeliveryStatus deliveryStatus;
}
