package com.mytests.hibernate.testMetamodel;

import com.mytests.hibernate.testMetamodel.data.*;
import com.mytests.hibernate.testMetamodel.repositories.CustomerRepository_;
import com.mytests.hibernate.testMetamodel.repositories.ItemsRepository_;
import com.mytests.hibernate.testMetamodel.repositories.OrderItemsRepository_;
import com.mytests.hibernate.testMetamodel.repositories.OrdersRepository_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.System.out;


public class RunMe {
    private static final SessionFactory factory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            factory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return factory.openSession();
    }

    public static void main(String[] args) {
        out.println("============ simple query:");
        inSession(factory, entityManager -> {
            for (Object d : entityManager.createQuery("from Customer where customerName = 'anna'").getResultList()) {
                out.println(d);
            }
        });
        out.println("============ find orders by cistomer name: ");
        for (Orders o : findOrders1("anna")) {
            out.println(o);
        }
        out.println("============ find items by category:");
        for (Items item : findItems1("fruits")) {
            out.println(item);
        }
        out.println("============ find order items by customer name:");
        for (OrderItems oi : findOrderItems1("irina")) {
            out.println(oi);
        }
        out.println("============ find all customers:");
        for (Customer customer : findAllCustomers()) {
            out.println(customer);
        }
        out.println("============ find vip customers:");
        for (Customer customer : findVipCustomers(true)) {
            out.println(customer);
        }


}

static void inSession(EntityManagerFactory factory, Consumer<EntityManager> work) {
    var entityManager = factory.createEntityManager();
    var transaction = entityManager.getTransaction();
    try {
        transaction.begin();
        work.accept(entityManager);
        transaction.commit();
    } catch (Exception e) {
        if (transaction.isActive()) transaction.rollback();
        throw e;
    } finally {
        entityManager.close();
    }
}

// The SampleQueries_ static class will remain unresolved until sources are generated
// build the project to make the references resolved
static List<Orders> findOrders1(String name) {
    var orders = factory.fromTransaction(session ->
            OrdersRepository_.getOrdersByCustomerName(session, name));
    return orders.isEmpty() ? new ArrayList<>() : orders;
}

static List<Items> findItems1(String category) {
    var items = factory.fromTransaction(session ->
            ItemsRepository_.findItemByCategory(session, category));
    return items.isEmpty() ? new ArrayList<>() : items;
}

static List<OrderItems> findOrderItems1(String name) {
    var orderItems = factory.fromTransaction(session ->
            OrderItemsRepository_.findOrderItemsByCustomerName(session, name));
    return orderItems.isEmpty() ? new ArrayList<>() : orderItems;
}
static List<OrderItems> findOrderItems2(String category) {
    var orderItems = factory.fromTransaction(session ->
            OrderItemsRepository_.findOrderItemsByItemsCategory(session, category));
    return orderItems.isEmpty() ? new ArrayList<>() : orderItems;
}
static List<OrderItems> findOrderItems3(OrderItemsPK id) {
    var orderItems = factory.fromTransaction(session ->
            OrderItemsRepository_.findOrderItemsById(session, id));
    return orderItems.isEmpty() ? new ArrayList<>() : orderItems;
}
static List<OrderItems> findOrderItems4(Integer id1, Integer id2) {
    var orderItems = factory.fromTransaction(session ->
            OrderItemsRepository_.findOrderItemsByIdPart(session, id1, id2));
    return orderItems.isEmpty() ? new ArrayList<>() : orderItems;
}
static List<Customer> findAllCustomers() {
    var customers = factory.fromTransaction(CustomerRepository_::findAll);
    return customers.isEmpty() ? new ArrayList<>() : customers;
}
static List<Customer> findVipCustomers(Boolean flag) {
    var customers = factory.fromTransaction(session ->
            CustomerRepository_.findVips(session, flag));
    return customers.isEmpty() ? new ArrayList<>() : customers;
}

}
