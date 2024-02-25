package com.mytests.hibernate.testMetamodel.data;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "customers", schema = "shop")
public class Customer {
    @Id @Column(name = "customer_id")
    private Integer customerId;

    @Basic @Column(name = "customer_name")
    private String customerName;

    @Embedded
    CustomerAttributes customerAttributes;

    @OneToMany(mappedBy = "customers")
    private List<Orders> orders;

    public CustomerAttributes getCustomerAttributes() {
        return customerAttributes;
    }

    public void setCustomerAttributes(CustomerAttributes customerAttributes) {
        this.customerAttributes = customerAttributes;
    }

    public Integer getCustomerId() {
        return customerId;
    }
    
    public List<Orders> getOrders() {
        return orders;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public void setOrders(List<Orders> ordersByCustomerId) {
        this.orders = ordersByCustomerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "customerId=" + customerId +
               ", customerName='" + customerName + '\'' +
               ", " + customerAttributes +
               '}';
    }
}
