package com.uit.danangfinancialtower.mapper.impl;

import com.uit.danangfinancialtower.dto.BuildingDto;
import com.uit.danangfinancialtower.entity.BuildingEntity;
import com.uit.danangfinancialtower.mapper.BuildingDtoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * BuildingDtoMapperImpl
 */
@Component
public class BuildingDtoMapperImpl implements BuildingDtoMapper {

    @Override
    public BuildingDto toDto(BuildingEntity entity) {
        if (Objects.isNull(entity))
            return null;
        BuildingDto dto = new BuildingDto();
        dto.setId(entity.getId())
            .setBuildingName(entity.getBuildingName())
            .setBuildingAddress(entity.getBuildingAddress())
            .setBuildingDescription(entity.getBuildingDescription())
            .setBuildingHeight(entity.getBuildingHeight());
        return dto;
    }

    @Override
    public List<BuildingDto> toDtoList(List<BuildingEntity> entities) {
        if (Objects.isNull(entities) || entities.isEmpty())
            return Collections.emptyList();
        List<BuildingDto> dtos = new ArrayList<>();
        entities.forEach(building -> dtos.add(this.toDto(building)));
        return dtos;
    }
}
