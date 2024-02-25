package com.mytests.hibernate.testMetamodel.repositories;

import com.mytests.hibernate.testMetamodel.data.OrderItems;
import com.mytests.hibernate.testMetamodel.data.OrderItemsBase;
import com.mytests.hibernate.testMetamodel.data.OrderItemsPK;
import org.hibernate.annotations.processing.Find;

import java.util.List;

/**
 * *
 * <p>Created by irina on 2/22/2024.</p>
 * <p>Project: hibernate-jpa-metamodel-associations</p>
 * *
 */
public interface OrderItemsRepository {
    @Find
    List<OrderItems> findOrderItemsByItemsCategory(String items$category);

    @Find
    List<OrderItems> findOrderItemsByCustomerName(String orders$customers$customerName );

    // doesn't work for some reason (inherited property
    //@Find()
    //List<OrderItems> findOrderItemsByAmount(Integer items_number);

    @Find
    List<OrderItems> findOrderItemsById(OrderItemsPK id);

    // embeddedId attributes
    @Find
    List<OrderItems> findOrderItemsByIdPart(Integer id$itemId, Integer id$orderId);

}
