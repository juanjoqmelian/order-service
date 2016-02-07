package com.dragosolutions.microservices.order.repository;


import com.dragosolutions.microservices.order.Order;

import java.util.List;

public interface OrderRepository {

    Order getOrder(String id);

    List<Order> getOrdersByCustomer(String customerId);

    String create(Order order);

    void update(Order order);

    void delete(String orderId);
}
