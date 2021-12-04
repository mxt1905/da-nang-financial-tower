package com.uit.danangfinancialtower.mapper;

/**
 * BaseArrayMapper
 */
public interface BaseArrayMapper<E, T> {

    T[] toDtoArray(E entity);
}
