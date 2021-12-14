package com.uit.danangfinancialtower.mapper;

import com.uit.danangfinancialtower.dto.BodyDto;
import com.uit.danangfinancialtower.entity.BodyEntity;
import org.springframework.stereotype.Component;

/**
 * BodyDtoMapper
 */
@Component
public interface BodyDtoMapper extends BaseMapper<BodyEntity, BodyDto>,
    BaseCollectionMapper<BodyEntity, BodyDto> {
}
