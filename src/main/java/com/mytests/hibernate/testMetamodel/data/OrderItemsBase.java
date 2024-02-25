package com.mytests.hibernate.testMetamodel.data;

import jakarta.persistence.*;


@MappedSuperclass
public class OrderItemsBase {

    @Column(name = "amount")
    protected Integer items_number;





    public Integer getItems_number() {
        return items_number;
    }

    public void setItems_number(Integer amount) {
        this.items_number = amount;
    }
}
