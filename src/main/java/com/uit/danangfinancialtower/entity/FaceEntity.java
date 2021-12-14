package com.uit.danangfinancialtower.entity;

import com.uit.danangfinancialtower.constants.TableConst.ColumnName;
import com.uit.danangfinancialtower.constants.TableConst.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FaceEntity
 */
@Entity
@Table(name = TableName.FACE)
@Getter
@Setter
public class FaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnName.TYPE_ID)
    private TypeEntity type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnName.SYMBOL_ID)
    private SymbolEntity symbol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnName.BODY_ID)
    private BodyEntity body;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = TableName.NODE_FACE,
        joinColumns = @JoinColumn(name = ColumnName.FACE_ID),
        inverseJoinColumns = @JoinColumn(name = ColumnName.NODE_ID)
    )
    private List<NodeEntity> nodes = new ArrayList<>();


}
