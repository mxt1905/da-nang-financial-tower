package com.uit.danangfinancialtower.mapper;

import com.uit.danangfinancialtower.dto.FaceDto;
import com.uit.danangfinancialtower.entity.FaceEntity;
import org.springframework.stereotype.Component;

/**
 * FaceDtoMapper
 */
@Component
public interface FaceDtoMapper extends BaseMapper<FaceEntity, FaceDto>,
    BaseCollectionMapper<FaceEntity, FaceDto> {
}
