package org.example.Mappers.inventory;

import org.example.dtos.inventory.InventoryDto;
import org.example.presistance.entities.Inventory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InventoryMapper {
    @Mapping(source = "storeId", target = "store.id")
    @Mapping(source = "filmId", target = "film.id")
    Inventory toEntity(InventoryDto inventoryDto);

    @InheritInverseConfiguration(name = "toEntity")
    InventoryDto toDto(Inventory inventory);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Inventory partialUpdate(InventoryDto inventoryDto, @MappingTarget Inventory inventory);
}