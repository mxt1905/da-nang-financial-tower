package com.uit.danangfinancialtower.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * FaceDto
 */
@Getter
@Setter
public class FaceDto {

    private String type;
    private SymbolDto symbol;
    private Double[][] rings;
}
