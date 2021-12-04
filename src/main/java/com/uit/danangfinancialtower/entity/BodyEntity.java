package com.uit.danangfinancialtower.entity;

import com.uit.danangfinancialtower.constants.TableConst.ColumnName;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bodyName;

    private String bodyAddress;

    private String bodyDesc;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = TableName.BODY_FACE,
        joinColumns = @JoinColumn(name = ColumnName.BODY_ID),
        inverseJoinColumns = @JoinColumn(name = ColumnName.FACE_ID)
    )
    private List<FaceEntity> faces = new ArrayList<>();
}
