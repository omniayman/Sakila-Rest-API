package org.example.services;

import org.example.Mappers.film.FilmMapper;
import org.example.Mappers.inventory.InventoryMapper;
import org.example.Mappers.inventory.InventoryRentalMapper;
import org.example.Mappers.store.StoreMapper;
import org.example.dtos.film.FilmDto;
import org.example.dtos.inventory.InventoryDto;
import org.example.dtos.inventory.InventoryRentalDto;
import org.example.dtos.store.StoreDto;
import org.example.presistance.daos.impl.InventoryDaoImpl;
import org.example.presistance.entities.Inventory;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventoryService {
    private InventoryMapper mapper;
    private InventoryDaoImpl inventoryDao;

    public InventoryService() {
        inventoryDao = new InventoryDaoImpl();
        mapper = Mappers.getMapper(InventoryMapper.class);
    }

    public List<InventoryDto> getAllInventories() {
        List<Inventory> inventories = inventoryDao.findAll();
        List<InventoryDto> inventoryDtos = new ArrayList<>();
        for (Inventory s : inventories) {
            inventoryDtos.add(mapper.toDto(s));
        }
        return inventoryDtos;
    }

    public InventoryRentalDto getInventoryById(int id) {
        InventoryRentalMapper inventoryRentalMapper = Mappers.getMapper(InventoryRentalMapper.class);
        Inventory inventory = inventoryDao.findById(id, Inventory.class);
        return inventoryRentalMapper.toDto(inventory);
    }


    public void updatePayment(InventoryDto inventoryDto) {


        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        inventoryDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());

        Inventory inventory = mapper.toEntity(inventoryDto);
        inventoryDao.update(inventory);
    }

    public void addPayment(InventoryDto inventoryDto) throws InvalidDataException {

        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();

        inventoryDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Inventory inventory = mapper.toEntity(inventoryDto);
        inventoryDao.add(inventory);
    }

    public boolean checkInventoryInStock(int id) throws InvalidDataException {
        return inventoryDao.checkInventoryInStock(id);
    }

    public FilmDto getFilmByInventoryId(int id) throws InvalidDataException {
        FilmMapper filmMapper = Mappers.getMapper(FilmMapper.class);
        return filmMapper.toDto(inventoryDao.getFilmByInventoryId(id));
    }

    public StoreDto getStoreByInventoryId(int id) throws InvalidDataException {
        StoreMapper storeMapper = Mappers.getMapper(StoreMapper.class);
        return storeMapper.toDto(inventoryDao.getStoreByInventoryId(id));
    }


}
