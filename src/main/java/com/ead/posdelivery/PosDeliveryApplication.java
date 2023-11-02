package com.ead.posdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PosDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PosDeliveryApplication.class, args);
    }

}
