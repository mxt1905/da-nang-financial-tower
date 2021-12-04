package com.uit.danangfinancialtower.entity;

import com.uit.danangfinancialtower.constants.TableConst.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * SymbolTypeEntity
 */
@Entity
@Table(name = TableName.SYMBOL_TYPE)
@Getter
@Setter
public class SymbolTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String symbolTypeName;
}
