package com.uit.danangfinancialtower.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * FacePolygonDto
 */
@Getter
@Setter
public class FacePolygonDto extends FaceDto {

    private Double[][] rings;

    @Override
    public void setCoordinates(Double[][] coordinates) {
        this.rings = coordinates;
    }
}
