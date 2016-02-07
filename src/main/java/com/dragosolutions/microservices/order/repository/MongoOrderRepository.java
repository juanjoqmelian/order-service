package com.dragosolutions.microservices.order.repository;


import com.dragosolutions.microservices.order.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoOrderRepository implements OrderRepository {

    private MongoTemplate mongoTemplate;


    public MongoOrderRepository(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Order getOrder(String id) {
        return mongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), Order.class);
    }

    @Override
    public List<Order> getOrdersByCustomer(String customerId) {
        return mongoTemplate.find(Query.query(Criteria.where("customerId").is(customerId)), Order.class);
    }

    @Override
    public String create(Order order) {
        mongoTemplate.save(order);
        return order.getId();
    }

    @Override
    public void update(Order order) {
        mongoTemplate.save(order);
    }

    @Override
    public void delete(String orderId) {
        final Order order = this.getOrder(orderId);
        mongoTemplate.remove(order);
    }
}
