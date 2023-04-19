package org.example.presistance.daos.impl;

import jakarta.persistence.EntityManager;
import org.example.presistance.EntityManagerFactoryProvider;
import org.example.presistance.daos.interfaces.InventoryDao;
import org.example.presistance.entities.Film;
import org.example.presistance.entities.Inventory;
import org.example.presistance.entities.Store;
import org.example.presistance.exceptionHandler.InvalidDataException;

public class InventoryDaoImpl extends Crud<Inventory, Integer> implements InventoryDao {
    EntityManager entityManager = EntityManagerFactoryProvider.getInstance().createEntityManager();

    @Override
    public boolean checkInventoryInStock(int id) throws InvalidDataException {
        Inventory inventory = entityManager.find(Inventory.class, id);
        if (inventory == null) {
            throw new InvalidDataException("inventory id does not exist");
        }

        return (boolean) entityManager.createQuery("select inventory_in_stock(?1)")
                .setParameter(1, id)
                .getSingleResult();
    }

    @Override
    public Film getFilmByInventoryId(int id) throws InvalidDataException {

        Film film = (Film) entityManager.createQuery("select c.film from Inventory c where c.id=?1")
                .setParameter(1, id)
                .getSingleResult();
        if (film == null)
            throw new InvalidDataException("inventory id does not exist");
        return film;
    }

    @Override
    public Store getStoreByInventoryId(int id) throws InvalidDataException {
        Store store = (Store) entityManager.createQuery("select c.store from Inventory c where c.id=?1")
                .setParameter(1, id)
                .getSingleResult();
        if (store == null)
            throw new InvalidDataException("inventory id does not exist");
        return store;
    }
}
