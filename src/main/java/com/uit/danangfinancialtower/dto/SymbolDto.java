package com.uit.danangfinancialtower.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * SymbolDto
 */
@Getter
@Setter
public class SymbolDto {

    private String type;
    private Double[] color = new Double[4];
}
