package com.ead.posdelivery.Repository;

import com.ead.posdelivery.Entity.DeliveryPerson;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryPersonRepository extends MongoRepository<DeliveryPerson,String> {

    DeliveryPerson findFirstByOrderByDeliveryPersonIdDesc();
    DeliveryPerson getDeliveryPersonByDeliveryPersonId(String deliveryPersonId);
    DeliveryPerson getDeliveryPersonByEmail(String deliverPersonEmail);

}
