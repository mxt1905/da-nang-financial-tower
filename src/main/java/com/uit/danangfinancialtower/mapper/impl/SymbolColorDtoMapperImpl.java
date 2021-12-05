package com.uit.danangfinancialtower.mapper.impl;

import com.uit.danangfinancialtower.constants.utils.Arrays;
import com.uit.danangfinancialtower.entity.SymbolColorEntity;
import com.uit.danangfinancialtower.mapper.SymbolColorDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * SymbolColorDtoMapperImpl
 */
@Component
public class SymbolColorDtoMapperImpl implements SymbolColorDtoMapper {

    @Override
    public Double[] toDtoArray(SymbolColorEntity entity) {
        if (Objects.isNull(entity))
            return Arrays.EMPTY_DOUBLE_ARRAY;
        return new Double[] {
            entity.getRed(),
            entity.getGreen(),
            entity.getBlue(),
            entity.getOpacity()
        };
    }
}
