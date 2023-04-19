package org.example.Mappers.film;

import org.example.dtos.film.FilmDto;
import org.example.presistance.entities.Film;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FilmMapper {

    @Mapping(source = "originalLanguageId", target = "originalLanguage.id")
    @Mapping(source = "languageId", target = "language.id")
    Film toEntity(FilmDto filmDto);

    @InheritInverseConfiguration(name = "toEntity")
    FilmDto toDto(Film film);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film partialUpdate(FilmDto filmDto, @MappingTarget Film film);
//    default List<Integer> inventoriesToInventoryIds(List<Inventory> inventories) {
//        return inventories.stream()
//                .map(Inventory::getId)
//                .collect(Collectors.toList());
//    }
//
//    default List<Inventory> inventoryIdsToInventories(List<Integer> inventoryIds) {
//        return inventoryIds.stream()
//                .map(id -> {
//                    Inventory inventory = new Inventory();
//                    inventory.setId(id);
//                    return inventory;
//                })
//                .collect(Collectors.toList());
//    }
}