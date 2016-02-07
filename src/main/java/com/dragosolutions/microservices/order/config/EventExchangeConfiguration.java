package com.dragosolutions.microservices.order.config;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

public class EventExchangeConfiguration {

    @NotEmpty
    private String host;
    @NumberFormat
    private int port;
    @NotEmpty
    private String topicName;


    public EventExchangeConfiguration() {}


    @JsonProperty
    public String getHost() {
        return host;
    }

    @JsonProperty
    public int getPort() {
        return port;
    }

    @JsonProperty
    public String getTopicName() {
        return topicName;
    }
}
