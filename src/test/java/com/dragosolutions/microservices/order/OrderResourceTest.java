package com.dragosolutions.microservices.order;


import com.dragosolutions.microservices.order.config.EventExchangeConfiguration;
import com.dragosolutions.microservices.order.repository.MongoOrderRepository;
import com.dragosolutions.microservices.order.repository.OrderRepository;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OrderResourceTest {

    private OrderResource orderResource;

    private OrderRepository mockOrderRepository;

    private Mockery mockery = new JUnit4Mockery() {
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };


    @Before
    public void setUp() {

        final EventExchangeConfiguration eventExchangeConfiguration = new EventExchangeConfiguration();
        orderResource = new OrderResource(eventExchangeConfiguration);
        mockOrderRepository = mockery.mock(MongoOrderRepository.class);
        orderResource.setMongoOrderRepository(mockOrderRepository);
    }


    @Test
    public void getOrder_shouldReturnAnExistingOrder() {

        final String customerId = "1234";
        final String orderId = UUID.randomUUID().toString();
        final Order order = new Order(orderId, customerId, new BigDecimal("10.50"), "item1234", 2);

        mockery.checking(new Expectations() {
            {

                oneOf(mockOrderRepository).getOrder(orderId);
                will(returnValue(order));
            }
        });

        Response response = orderResource.getOrder(orderId);

        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));
        Order retrievedOrder = (Order) response.getEntity();
        assertThat(retrievedOrder, is(order));
    }
}
