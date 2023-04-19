package org.example.presistance.daos.impl;

import jakarta.persistence.EntityManager;
import org.example.presistance.EntityManagerFactoryProvider;
import org.example.presistance.daos.interfaces.PaymentDao;
import org.example.presistance.entities.Customer;
import org.example.presistance.entities.Payment;
import org.example.presistance.entities.Rental;
import org.example.presistance.entities.Staff;

import java.math.BigDecimal;

public class PaymentDaoImpl extends Crud<Payment, Integer> implements PaymentDao {
    EntityManager entityManager = EntityManagerFactoryProvider.getInstance().createEntityManager();

    @Override
    public Customer getCustomerByPayment(int id) {
        return (Customer) entityManager.createQuery("select c.customer from Payment c where c.id=?1")
                .setParameter(1, id)
                .getSingleResult();
    }

    @Override
    public Rental getRentalByPayment(int id) {
        return (Rental) entityManager.createQuery("select c.rental from Payment c where c.id=?1")
                .setParameter(1, id)
                .getSingleResult();
    }

    @Override
    public BigDecimal getMaxPayment() {
        return (BigDecimal) entityManager.createQuery("select max(c.amount) from Payment c").getSingleResult();
    }

    @Override
    public Staff getStaffByPayment(int id) {
        return (Staff) entityManager.createQuery("select c.staff from Payment c where c.id=?1")
                .setParameter(1, id)
                .getSingleResult();
    }
}
