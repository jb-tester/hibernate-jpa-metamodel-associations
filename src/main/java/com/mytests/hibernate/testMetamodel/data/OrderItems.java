package com.mytests.hibernate.testMetamodel.data;

import jakarta.persistence.*;


@Entity
@Table(name = "order_items", schema = "shop")
@AttributeOverride(name = "items_number", column = @Column(name = "amount"))
public class OrderItems extends OrderItemsBase{

    @EmbeddedId
    OrderItemsPK id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    protected Items items;


    public OrderItemsPK getId() {
        return id;
    }

    public void setId(OrderItemsPK id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "id=" + id +
                ", items=" + getItems() +
                ", amount=" + getItems_number() +
                '}';
    }

   }
