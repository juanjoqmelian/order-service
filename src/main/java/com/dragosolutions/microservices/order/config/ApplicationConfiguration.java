package com.dragosolutions.microservices.order.config;

import io.dropwizard.Configuration;

import javax.validation.Valid;


public class ApplicationConfiguration extends Configuration {

    @Valid
    private OrderServiceConfiguration order;

    @Valid
    private EventExchangeConfiguration events;


    public OrderServiceConfiguration getOrder() {
        return order;
    }

    public void setOrder(OrderServiceConfiguration order) {
        this.order = order;
    }

    public EventExchangeConfiguration getEvents() {
        return events;
    }

    public void setEvents(EventExchangeConfiguration events) {
        this.events = events;
    }
}
