package com.bkap.vn.common.entity;
// Generated Dec 6, 2017 9:49:55 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * RoleByGroupRole generated by hbm2java
 */
@Entity
@Table(name = "role_by_group_role"
        , schema = "dbo"
        , catalog = "shop_online"
)
public class RoleByGroupRole implements java.io.Serializable {


    private int id;
    private GroupRole groupRole;
    private Role role;

    public RoleByGroupRole() {
    }
    public RoleByGroupRole(int id, GroupRole groupRole, Role role) {
        this.id = id;
        this.groupRole = groupRole;
        this.role = role;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_role_id", nullable = false)
    public GroupRole getGroupRole() {
        return this.groupRole;
    }

    public void setGroupRole(GroupRole groupRole) {
        this.groupRole = groupRole;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}


