package org.example.Mappers.actor;

import org.example.dtos.actor.ActorDto;
import org.example.presistance.entities.Actor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActorMapper {
    Actor toEntity(ActorDto actorDto);

    ActorDto toDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor partialUpdate(ActorDto actorDto, @MappingTarget Actor actor);
}