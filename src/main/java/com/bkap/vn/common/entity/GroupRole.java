package com.bkap.vn.common.entity;
// Generated Dec 6, 2017 9:49:55 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GroupRole generated by hbm2java
 */
@Entity
@Table(name="group_role"
    ,schema="dbo"
    ,catalog="shop_online"
)
public class GroupRole  implements java.io.Serializable {


     private int id;
     private Admin adminByAdminUpdate;
     private Admin adminByAdminCreate;
     private String groupRoleName;
     private String description;
     private Date createDate;
     private Date updateDate;
     private Set<RoleByGroupRole> roleByGroupRoles = new HashSet<RoleByGroupRole>(0);

    public GroupRole() {
    }

	
    public GroupRole(int id, String groupRoleName) {
        this.id = id;
        this.groupRoleName = groupRoleName;
    }
    public GroupRole(int id, Admin adminByAdminUpdate, Admin adminByAdminCreate, String groupRoleName, String description, Date createDate, Date updateDate, Set<RoleByGroupRole> roleByGroupRoles) {
       this.id = id;
       this.adminByAdminUpdate = adminByAdminUpdate;
       this.adminByAdminCreate = adminByAdminCreate;
       this.groupRoleName = groupRoleName;
       this.description = description;
       this.createDate = createDate;
       this.updateDate = updateDate;
       this.roleByGroupRoles = roleByGroupRoles;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admin_update")
    public Admin getAdminByAdminUpdate() {
        return this.adminByAdminUpdate;
    }
    
    public void setAdminByAdminUpdate(Admin adminByAdminUpdate) {
        this.adminByAdminUpdate = adminByAdminUpdate;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admin_create")
    public Admin getAdminByAdminCreate() {
        return this.adminByAdminCreate;
    }
    
    public void setAdminByAdminCreate(Admin adminByAdminCreate) {
        this.adminByAdminCreate = adminByAdminCreate;
    }

    
    @Column(name="group_role_name", nullable=false)
    public String getGroupRoleName() {
        return this.groupRoleName;
    }
    
    public void setGroupRoleName(String groupRoleName) {
        this.groupRoleName = groupRoleName;
    }

    
    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", length=23)
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date", length=23)
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="groupRole")
    public Set<RoleByGroupRole> getRoleByGroupRoles() {
        return this.roleByGroupRoles;
    }
    
    public void setRoleByGroupRoles(Set<RoleByGroupRole> roleByGroupRoles) {
        this.roleByGroupRoles = roleByGroupRoles;
    }




}


