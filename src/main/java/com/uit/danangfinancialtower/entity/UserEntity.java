package com.uit.danangfinancialtower.entity;

import com.uit.danangfinancialtower.constants.TableConst.ColumnName;
import com.uit.danangfinancialtower.constants.TableConst.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * UserEntity
 */
@Entity
@Table(name = TableName.USER)
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = ColumnName.ROLE_ID)
    private RoleEntity role;
}
