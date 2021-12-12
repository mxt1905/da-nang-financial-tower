package com.uit.danangfinancialtower.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * FaceDto
 */
@Getter
@Setter
public abstract class FaceDto {

    private String type;
    private SymbolDto symbol;

    public abstract void setCoordinates(Double[][] coordinates);
}
