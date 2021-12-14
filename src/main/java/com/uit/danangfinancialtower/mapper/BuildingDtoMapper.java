package com.uit.danangfinancialtower.mapper;

import com.uit.danangfinancialtower.dto.BuildingDto;
import com.uit.danangfinancialtower.entity.BuildingEntity;
import org.springframework.stereotype.Component;

/**
 * BuildingDtoMapper
 */
@Component
public interface BuildingDtoMapper extends BaseMapper<BuildingEntity, BuildingDto>,
    BaseCollectionMapper<BuildingEntity, BuildingDto> {
}
