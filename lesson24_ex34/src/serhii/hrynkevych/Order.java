package serhii.hrynkevych;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private final long id;
    private final String status;
    private final LocalDate orderDate;
    private final LocalDate deliveryDate;
    List<Product> products;
    Customer customer;

    public Order(long id, String status, LocalDate orderData, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderData;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "\nOrder{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderData=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", \ncustomer=" + customer +
                "}\n";
    }
}
