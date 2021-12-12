package com.uit.danangfinancialtower.entity;

import com.uit.danangfinancialtower.constants.TableConst.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BuildingEntity
 */
@Entity
@Table(name = TableName.BUILDING)
@Getter
@Setter
public class BuildingEntity {

    private static final String BUILDING_MAP = "building";

    @Id
    private String id;

    private String buildingName;

    private String buildingAddress;

    private String buildingDescription;

    private Double buildingHeight;

    private Boolean isDeleted;

    @OneToMany(mappedBy = BUILDING_MAP, fetch = FetchType.LAZY)
    private List<BodyEntity> bodies = new ArrayList<>();
}
