package com.dragosolutions.microservices.order.config;

import com.dragosolutions.microservices.order.repository.MongoOrderRepository;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;

@Configuration
@ComponentScan(value = {
        "com.dragosolutions.microservices.order"
})
public class SpringConfiguration {

    @Bean(name = "mongoOrderRepository")
    public MongoOrderRepository getMongoOrderRepository() {

        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        final MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "com/drago/microservices/order");
        final MongoOrderRepository mongoOrderRepository = new MongoOrderRepository(mongoTemplate);
        return mongoOrderRepository;
    }

}
