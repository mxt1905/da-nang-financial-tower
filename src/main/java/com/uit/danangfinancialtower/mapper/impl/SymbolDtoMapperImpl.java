package com.uit.danangfinancialtower.mapper.impl;

import com.uit.danangfinancialtower.dto.SymbolDto;
import com.uit.danangfinancialtower.entity.SymbolEntity;
import com.uit.danangfinancialtower.mapper.SymbolColorDtoMapper;
import com.uit.danangfinancialtower.mapper.SymbolDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * SymbolDtoMapperImpl
 */
@Component
@RequiredArgsConstructor
public class SymbolDtoMapperImpl implements SymbolDtoMapper {

    private final SymbolColorDtoMapper symbolColorDtoMapper;

    @Override
    public SymbolDto toDto(SymbolEntity entity) {
        if (Objects.isNull(entity))
            return null;
        SymbolDto dto = new SymbolDto();
        dto.setType(entity.getSymbolType().getSymbolTypeName())
            .setColor(symbolColorDtoMapper.toDtoArray(entity.getSymbolColor()));
        return dto;
    }
}
