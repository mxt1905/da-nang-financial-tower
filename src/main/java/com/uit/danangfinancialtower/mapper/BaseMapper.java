package com.uit.danangfinancialtower.mapper;

/**
 * BaseMapper
 */
public interface BaseMapper<E, D> {

    D toDto(E entity);
}
