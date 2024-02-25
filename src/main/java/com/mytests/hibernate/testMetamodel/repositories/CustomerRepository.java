package com.mytests.hibernate.testMetamodel.repositories;

import com.mytests.hibernate.testMetamodel.data.Customer;
import com.mytests.hibernate.testMetamodel.data.Orders;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.annotations.processing.Find;
import org.hibernate.query.Order;
import org.hibernate.query.Page;

import java.util.List;
import java.util.Set;

/**
 * *
 * <p>Created by irina on 2/22/2024.</p>
 * <p>Project: hibernate-jpa-metamodel-associations</p>
 * *
 */
public interface CustomerRepository {
    @Find
    List<Customer> findAll(Session session);

    @Find
    List<Customer> findByCustomerName(EntityManager entityManager, String customerName);

    @Find
    List<Customer> findCustomers(Page page, Order<? super Customer>... order);

    // invalid query; error is reported - ok
    //@Find
    //Customer findCustomer(Page page, Order<? super Customer>... order);


    // embedded attributes
    @Find
    List<Customer> findVips(Boolean customerAttributes$vip);

    @Find
    Customer findByOrders(Session session, List<Orders> orders);

    // incorrect, List<Orders> parameter is expected
   // @Find
   // Customer findByOrder(Session session, Orders orders);

    // incorrect, List<Orders> parameter is expected
   // @Find
   // Customer findByOrdersSet(Set<Orders> orders);

    // incorrect, List<Orders> parameter is expected
    // @Find
   // Customer findByOrdersCollection(Set<Orders> orders);

    // incorrect, List<Orders> parameter is expected
    // @Find
    // Customer findByOrderChild(List<? extends Orders> orders);




}
