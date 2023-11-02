package com.ead.posdelivery.Service;

import com.ead.posdelivery.Entity.Delivery;
import com.ead.posdelivery.Enum.DeliveryStatus;
import com.ead.posdelivery.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public String generateDeliveryId(){
        Delivery lastDelivery = deliveryRepository.findFirstByOrderByDeliveryIdDesc();
        if(lastDelivery != null){
            int lastDeliveryId = Integer.parseInt(lastDelivery.getDeliveryId().substring(1));
            int newDeliveryId = lastDeliveryId + 1;
            return "D" + newDeliveryId;
        }else {
            return "D1";
        }
    }

    public ResponseEntity<String> addDelivery(Delivery delivery) {
        delivery.setDeliveryId(generateDeliveryId());
        deliveryRepository.save(delivery);
        return ResponseEntity.ok("Delivery added successfully");
    }

    public ResponseEntity<String> updateStatus(String deliveryId, DeliveryStatus status) {
        Delivery delivery = deliveryRepository.getDeliveryByDeliveryId(deliveryId);
        if (delivery == null) {
            return ResponseEntity.badRequest().body("Delivery not found");
        }
        delivery.setDeliveryStatus(status);
        deliveryRepository.save(delivery);
        return ResponseEntity.ok("Delivery status updated successfully");
    }
}
