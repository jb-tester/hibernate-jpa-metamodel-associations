package com.mytests.hibernate.testMetamodel.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class OrderItemsPK //implements Serializable
{
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "item_id")
    private Integer itemId;

    
    public Integer getOrderId() {
        return orderId;
    }
    
    public Integer getItemId() {
        return itemId;
    }

    @Override
    public String toString() {
        return "OrderItemsPK{" +
                "orderId=" + orderId +
                ", itemId=" + itemId +
                '}';
    }
}
