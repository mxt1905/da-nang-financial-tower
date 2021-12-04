package com.uit.danangfinancialtower.mapper.impl;

import com.uit.danangfinancialtower.dto.FaceDto;
import com.uit.danangfinancialtower.entity.FaceEntity;
import com.uit.danangfinancialtower.mapper.FaceDtoMapper;
import com.uit.danangfinancialtower.mapper.NodeDtoMapper;
import com.uit.danangfinancialtower.mapper.SymbolDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * FaceDtoMapperImpl
 */
@Component
@RequiredArgsConstructor
public class FaceDtoMapperImpl implements FaceDtoMapper {

    private final NodeDtoMapper nodeDtoMapper;
    private final SymbolDtoMapper symbolDtoMapper;

    @Override
    public FaceDto toDto(FaceEntity entity) {
        if (Objects.isNull(entity))
            return null;
        FaceDto dto = new FaceDto();
        Double[][] rings = new Double[entity.getNodes().size()][];
        int length = entity.getNodes().size();
        for (int i = 0; i < length; i++)
            rings[i] = nodeDtoMapper.toDtoArray(entity.getNodes().get(i));
        dto.setType(entity.getType().getTypeName())
            .setSymbol(symbolDtoMapper.toDto(entity.getSymbol()))
            .setRings(rings);
        return dto;
    }

    @Override
    public List<FaceDto> toDtoList(List<FaceEntity> entities) {
        if (Objects.isNull(entities) || entities.isEmpty())
            return Collections.emptyList();
        List<FaceDto> dtos = new ArrayList<>();
        entities.forEach(face -> dtos.add(this.toDto(face)));
        return dtos;
    }
}
