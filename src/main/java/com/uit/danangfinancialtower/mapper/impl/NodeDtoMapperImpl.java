package com.uit.danangfinancialtower.mapper.impl;

import com.uit.danangfinancialtower.constants.utils.Arrays;
import com.uit.danangfinancialtower.entity.NodeEntity;
import com.uit.danangfinancialtower.mapper.NodeDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * NodeDtoMapperImpl
 */
@Component
public class NodeDtoMapperImpl implements NodeDtoMapper {

    @Override
    public Double[] toDtoArray(NodeEntity entity) {
        if (Objects.isNull(entity))
            return Arrays.EMPTY_DOUBLE_ARRAY;
        return new Double[] {
            entity.getX(),
            entity.getY(),
            entity.getZ()};
    }
}
