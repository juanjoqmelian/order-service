package com.dragosolutions.microservices.order.config;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

public class OrderServiceConfiguration {

    @NotEmpty
    private String host;
    @NumberFormat
    private int port;

    public OrderServiceConfiguration() {
    }

    @JsonProperty
    public String getHost() {
        return host;
    }

    @JsonProperty
    public int getPort() {
        return port;
    }
}
