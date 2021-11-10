package com.puentedigital.multiposting.dto.mappers;

import java.util.List;
import java.util.Set;

public interface EntityMapper<DTO, Entity> {

    Entity toEntity(DTO dto);
    DTO toDTO(Entity entity);

    Set<DTO> toDtoSet(Set<Entity> entities);
    List<DTO> toDtoList(List<Entity> entities);

    Set<Entity> toEntitySet(Set<DTO> DTOs);
    List<Entity> toEntityList(List<DTO> DTOs);
}
