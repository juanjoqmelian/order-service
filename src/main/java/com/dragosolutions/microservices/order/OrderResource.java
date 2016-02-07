package com.dragosolutions.microservices.order;

import com.codahale.metrics.annotation.Timed;
import com.dragosolutions.microservices.order.config.EventExchangeConfiguration;
import com.dragosolutions.microservices.order.repository.OrderRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/orders")
@Component
public class OrderResource {

    private OrderRepository mongoOrderRepository;


    public OrderResource(EventExchangeConfiguration configuration) {
        final String host = System.getenv("CUSTOMER_HOST") != null ? System.getenv("CUSTOMER_HOST") : configuration.getHost();
        final int port = System.getenv("CUSTOMER_PORT") != null ? Integer.valueOf(System.getenv("CUSTOMER_PORT")) : configuration.getPort();
    }


    @Path("/{id}")
    @GET
    @Timed
    @Produces("application/json")
    public Response getOrder(@PathParam("id") String id) {

        final Order order = mongoOrderRepository.getOrder(id);
        return Response.ok(order).build();
    }


    @Inject
    public void setMongoOrderRepository(OrderRepository mongoOrderRepository) {
        this.mongoOrderRepository = mongoOrderRepository;
    }
}
