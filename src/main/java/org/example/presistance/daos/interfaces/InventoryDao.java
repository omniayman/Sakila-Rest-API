package org.example.presistance.daos.interfaces;

import org.example.presistance.entities.Film;
import org.example.presistance.entities.Store;
import org.example.presistance.exceptionHandler.InvalidDataException;

public interface InventoryDao {
    public boolean checkInventoryInStock(int id) throws InvalidDataException;

    public Film getFilmByInventoryId(int id) throws InvalidDataException;

    public Store getStoreByInventoryId(int id) throws InvalidDataException;
}
