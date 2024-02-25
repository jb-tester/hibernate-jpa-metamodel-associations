package com.mytests.hibernate.testMetamodel.data;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "items", schema = "shop")
public class Items {
    @Id
    @Column(name = "item_id")
    private Integer itemId;
    
    @OneToMany(mappedBy = "items")
    private List<OrderItems> orderItems;
    
    @Basic
    @Column(name = "item_name")
    private String itemName;
    
    @Basic
    @Column(name = "category")
    private String category;
    
    @Basic
    @Column(name = "price")
    private Integer price;
    
    @Basic
    @Column(name = "available")
    private Integer available;

    
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItemsByItemId) {
        this.orderItems = orderItemsByItemId;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
