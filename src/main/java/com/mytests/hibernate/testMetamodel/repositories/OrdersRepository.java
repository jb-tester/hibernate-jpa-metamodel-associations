package com.mytests.hibernate.testMetamodel.repositories;

import com.mytests.hibernate.testMetamodel.data.Orders;
import org.hibernate.annotations.processing.Find;

import java.util.List;

/**
 * *
 * <p>Created by irina on 2/22/2024.</p>
 * <p>Project: hibernate-jpa-metamodel-associations</p>
 * *
 */
public interface OrdersRepository {

    @Find
    List<Orders> getOrdersByCustomerName(String customers$customerName);


    @Find
   // List<Orders> getOrdersById(Integer orderId); // Integer instead of int: error should be reported
    List<Orders> getOrdersById(int orderId);


    @Find
    //List<Orders> getOrdersByVip(Boolean urgent); // Boolean instead of boolean: error should be reported
    List<Orders> getOrdersByVip(boolean urgent);


}

