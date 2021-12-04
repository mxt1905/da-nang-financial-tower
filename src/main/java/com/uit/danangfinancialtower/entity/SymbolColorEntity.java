package com.uit.danangfinancialtower.entity;

import com.uit.danangfinancialtower.constants.TableConst.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * SymbolColorEntity
 */
@Entity
@Table(name = TableName.SYMBOL_COLOR)
@Getter
@Setter
public class SymbolColorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double red;

    private Double green;

    private Double blue;

    private Double opacity;
}
