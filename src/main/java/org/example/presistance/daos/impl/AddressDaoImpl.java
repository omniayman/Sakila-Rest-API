package org.example.presistance.daos.impl;

import jakarta.persistence.EntityManager;
import org.example.presistance.daos.interfaces.AddressDao;
import org.example.presistance.entities.*;

import java.util.List;

public class AddressDaoImpl extends Crud<Address, Integer> implements AddressDao {
    EntityManager entityManager = super.getEntityManager();

    public void add(Address address) {

        City city = super.getEntityManager().find(City.class, address.getCity().getId());
        address.setCity(city);


        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

    }

    @Override
    public void update(Address editedAddress) {
        City city = super.getEntityManager().find(City.class, editedAddress.getCity().getId());
        Address address = super.getEntityManager().find(Address.class, editedAddress.getId());


        entityManager.getTransaction().begin();
        address.setCity(city);
        address.setAddress(editedAddress.getAddress());
        address.setAddress2(editedAddress.getAddress2());
        address.setDistrict(editedAddress.getDistrict());
        address.setPhone(editedAddress.getPhone());
        address.setPostalCode(editedAddress.getPostalCode());

        entityManager.getTransaction().commit();
    }


    @Override
    public List<Customer> getCustomersByAddressId(int id) {
        List<Customer> customers = (List<Customer>) entityManager.createQuery(" from Customer c where c.address.id=?1").setParameter(1, id).getResultList();

        return customers;
    }

    @Override
    public List<Staff> getStaffByAddressId(int id) {
        List<Staff> staff = (List<Staff>) entityManager.createQuery(" from Staff s where s.address.id=?1").setParameter(1, id).getResultList();

        return staff;
    }

    @Override
    public List<Store> getStoreByAddressId(int id) {
        List<Store> stores = (List<Store>) entityManager.createQuery(" from Store s  where s.address.id=?1").setParameter(1, id).getResultList();

        return stores;
    }
}
