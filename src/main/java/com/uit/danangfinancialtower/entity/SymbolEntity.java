package com.uit.danangfinancialtower.entity;

import com.uit.danangfinancialtower.constants.TableConst.ColumnName;
import com.uit.danangfinancialtower.constants.TableConst.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * SymbolEntity
 */
@Entity
@Table(name = TableName.SYMBOL)
@Getter
@Setter
public class SymbolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnName.SYMBOL_TYPE_ID)
    private SymbolTypeEntity symbolType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnName.SYMBOL_COLOR_ID)
    private SymbolColorEntity symbolColor;
}
