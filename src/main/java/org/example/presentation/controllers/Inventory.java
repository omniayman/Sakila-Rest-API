package org.example.presentation.controllers;


import org.example.dtos.film.FilmDto;
import org.example.dtos.inventory.InventoryDto;
import org.example.dtos.inventory.InventoryRentalDto;
import org.example.dtos.store.StoreDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.InventoryService;

import java.util.List;

public class Inventory {
    InventoryService inventoryService = new InventoryService();

    public List<InventoryDto> getAllInventories() {

        return inventoryService.getAllInventories();
    }

    public InventoryRentalDto getInventoryById(int id) {
        return inventoryService.getInventoryById(id);
    }


    public void updateInventory(InventoryDto inventoryDto) {


        inventoryService.updatePayment(inventoryDto);
    }

    public void addInventory(InventoryDto inventoryDto) throws InvalidDataException {

        inventoryService.addPayment(inventoryDto);
    }

    public boolean checkInventoryInStock(int id) throws InvalidDataException {
        return inventoryService.checkInventoryInStock(id);
    }

    public FilmDto getFilmByInventoryId(int id) throws InvalidDataException {
        return inventoryService.getFilmByInventoryId(id);
    }

    public StoreDto getStoreByInventoryId(int id) throws InvalidDataException {
        return inventoryService.getStoreByInventoryId(id);
    }
}
