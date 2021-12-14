package com.uit.danangfinancialtower.entity;

import com.uit.danangfinancialtower.constants.TableConst.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * NodeEntity
 */
@Entity
@Table(name = TableName.NODE)
@Getter
@Setter
public class NodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double x;

    private Double y;

    private Double z;
}
