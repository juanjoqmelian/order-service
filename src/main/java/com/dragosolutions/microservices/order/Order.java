package com.dragosolutions.microservices.order;


import java.math.BigDecimal;
import java.util.Objects;

public class Order {

    private String id;
    private final String customerId;
    private BigDecimal amount;
    private String itemId;
    private int units;


    public Order(final String id, final String customerId, final BigDecimal amount, String itemId, int units) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
    }

    public Order(final String customerId, final BigDecimal amount, String itemId, int units) {
        this.customerId = customerId;
        this.amount = amount;
    }


    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public int getUnits() {
        return units;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(units, order.units) &&
                Objects.equals(id, order.id) &&
                Objects.equals(customerId, order.customerId) &&
                Objects.equals(amount, order.amount) &&
                Objects.equals(itemId, order.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, amount, itemId, units);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", amount=" + amount +
                ", itemId='" + itemId + '\'' +
                ", units=" + units +
                '}';
    }
}
