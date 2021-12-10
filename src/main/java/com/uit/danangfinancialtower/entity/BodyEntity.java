package com.uit.danangfinancialtower.entity;

import com.uit.danangfinancialtower.constants.TableConst.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BodyEntity
 */
@Entity
@Table(name = TableName.BODY)
@Getter
@Setter
public class BodyEntity {

    private static final String BODY_MAP = "body";
    
    @Id
    private String id;

    private String bodyName;

    private String bodyDescription;

    @OneToMany(mappedBy = BODY_MAP, fetch = FetchType.LAZY)
    private List<FaceEntity> faces = new ArrayList<>();
}
