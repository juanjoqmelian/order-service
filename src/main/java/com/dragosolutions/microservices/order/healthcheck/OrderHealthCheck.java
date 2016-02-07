package com.dragosolutions.microservices.order.healthcheck;

import com.codahale.metrics.health.HealthCheck;
import com.dragosolutions.microservices.order.config.OrderServiceConfiguration;


public class OrderHealthCheck extends HealthCheck {


    public OrderHealthCheck(OrderServiceConfiguration configuration) {

    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
