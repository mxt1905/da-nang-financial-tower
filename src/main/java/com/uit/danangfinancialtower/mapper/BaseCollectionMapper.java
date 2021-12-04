package com.uit.danangfinancialtower.mapper;

import java.util.List;

/**
 * BaseCollectionMapper
 */
public interface BaseCollectionMapper<E, D> {

    List<D> toDtoList(List<E> entities);
}
