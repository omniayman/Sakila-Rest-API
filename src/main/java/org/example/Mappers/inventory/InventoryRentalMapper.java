package org.example.Mappers.inventory;

import org.example.dtos.inventory.InventoryRentalDto;
import org.example.presistance.entities.Inventory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InventoryRentalMapper {
    Inventory toEntity(InventoryRentalDto inventoryRentalDto);

    InventoryRentalDto toDto(Inventory inventory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Inventory partialUpdate(InventoryRentalDto inventoryRentalDto, @MappingTarget Inventory inventory);
}