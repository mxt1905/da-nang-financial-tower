package com.uit.danangfinancialtower.entity;

import com.uit.danangfinancialtower.constants.TableConst.TableName;
import com.uit.danangfinancialtower.constants.enums.Permission;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * PermissionEntity
 */
@Entity
@Table(name = TableName.PERMISSION)
@Getter
@Setter
public class PermissionEntity {

    @Id
    @Enumerated(EnumType.STRING)
    private Permission id;

    private String permissionDescription;
}
