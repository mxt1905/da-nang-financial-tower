package com.uit.danangfinancialtower.entity;

import com.uit.danangfinancialtower.constants.TableConst.ColumnName;
import com.uit.danangfinancialtower.constants.TableConst.TableName;
import com.uit.danangfinancialtower.constants.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * RoleEntity
 */
@Entity
@Table(name = TableName.ROLE)
@Getter
@Setter
public class RoleEntity {

    @Id
    @Enumerated(EnumType.STRING)
    private Role id;

    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = TableName.ROLE_PERMISSION,
        joinColumns = @JoinColumn(name = ColumnName.ROLE_ID),
        inverseJoinColumns = @JoinColumn(name = ColumnName.PERMISSION_ID)
    )
    private Set<PermissionEntity> permissions;
}
