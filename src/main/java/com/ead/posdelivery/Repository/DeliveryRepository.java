package com.ead.posdelivery.Repository;

import com.ead.posdelivery.Entity.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryRepository extends MongoRepository<Delivery,String> {
    Delivery findFirstByOrderByDeliveryIdDesc();
    Delivery getDeliveryByDeliveryId(String deliveryId);
}
