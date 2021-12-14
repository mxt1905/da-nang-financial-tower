package com.uit.danangfinancialtower.mapper.impl;

import com.uit.danangfinancialtower.dto.BodyDto;
import com.uit.danangfinancialtower.entity.BodyEntity;
import com.uit.danangfinancialtower.mapper.BodyDtoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * BodyDtoMapperImpl
 */
@Component
public class BodyDtoMapperImpl implements BodyDtoMapper {

    @Override
    public BodyDto toDto(BodyEntity entity) {
        if (Objects.isNull(entity))
            return null;
        BodyDto dto = new BodyDto();
        dto.setId(entity.getId())
            .setBodyName(entity.getBodyName())
            .setBodyDescription(entity.getBodyDescription());
        return dto;
    }

    @Override
    public List<BodyDto> toDtoList(List<BodyEntity> entities) {
        if (Objects.isNull(entities) || entities.isEmpty())
            return Collections.emptyList();
        List<BodyDto> dtos = new ArrayList<>();
        entities.forEach(body -> dtos.add(this.toDto(body)));
        return dtos;
    }
}
