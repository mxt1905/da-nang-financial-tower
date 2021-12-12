package com.uit.danangfinancialtower.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * FacePolylineDto
 */
@Getter
@Setter
public class FacePolylineDto extends FaceDto {

    private Double[][] paths;

    @Override
    public FaceDto setCoordinates(Double[][] coordinates) {
        paths = coordinates;
        return this;
    }
}
