package org.example.presistance.daos.impl;

import jakarta.persistence.EntityManager;
import org.example.presistance.daos.interfaces.CustomerDao;
import org.example.presistance.entities.*;

import java.util.List;

public class CustomerDaoImpl extends Crud<Customer, Integer> implements CustomerDao {
    EntityManager entityManager;

    public CustomerDaoImpl() {
        entityManager = super.getEntityManager();
    }

    @Override
    public void add(Customer customer) {

        Address address = super.getEntityManager().find(Address.class, customer.getAddress().getId());
        customer.setAddress(address);
        Store store = super.getEntityManager().find(Store.class, customer.getStore().getId());
        customer.setStore(store);
        // customer.setCreateDate();
        System.out.println(customer);
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

    }

    @Override
    public void update(Customer editedcustomer) {
        Customer customer = entityManager.find(Customer.class, editedcustomer.getId());
        EntityManager entityManager = super.getEntityManager();
        Address address = super.getEntityManager().find(Address.class, editedcustomer.getAddress().getId());

        Store store = super.getEntityManager().find(Store.class, editedcustomer.getStore().getId());
        System.out.println(customer);
        entityManager.getTransaction().begin();
        customer.setAddress(address);
        customer.setStore(store);
        customer.setActive(editedcustomer.getActive());
        customer.setEmail(editedcustomer.getEmail());
        customer.setFirstName(editedcustomer.getFirstName());
        customer.setLastName(editedcustomer.getLastName());
        entityManager.getTransaction().commit();
    }


    //when delete rental is impl rental
    public void delete(int id) {

    }

    @Override
    public Store getCustomerHomeStore(int id) {
        Store s = (Store) entityManager.createQuery("select c.store from Customer c where c.id=?1").setParameter(1, id).getSingleResult();

        return s;
    }

    @Override
    public List<Payment> getCustomerPayments(int id) {
        List<Payment> rentals = (List<Payment>) entityManager.createQuery(" from Payment r where r.customer.id=?1").setParameter(1, id).getResultList();

        return rentals;

    }

    @Override
    public Address getCustomerAddress(int id) {
        Address address = (Address) entityManager.createQuery("select c.address from Customer c where c.id=?1").setParameter(1, id).getSingleResult();

        return address;
    }

    @Override
    public List<Rental> getCustomerRentals(int id) {
        List<Rental> rentals = (List<Rental>) entityManager.createQuery(" from Rental r where r.customer.id=?1").setParameter(1, id).getResultList();

        return rentals;
    }
}
