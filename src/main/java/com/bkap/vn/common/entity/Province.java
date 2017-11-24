package com.bkap.vn.common.entity;
// Generated Aug 12, 2017 10:45:55 AM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Province generated by hbm2java
 */
@Entity
@Table(name="province"
    ,schema="dbo"
    ,catalog="shop_online"
)
public class Province  implements Serializable {


     private int id;
     private Admin adminByAdminUpdate;
     private Admin adminByAdminCreate;
     private Serializable provinceName;
     private Serializable description;
     private Date createDate;
     private Date updateDate;

    public Province() {
    }

	
    public Province(int id, Serializable provinceName) {
        this.id = id;
        this.provinceName = provinceName;
    }
    public Province(int id, Admin adminByAdminUpdate, Admin adminByAdminCreate, Serializable provinceName, Serializable description, Date createDate, Date updateDate) {
       this.id = id;
       this.adminByAdminUpdate = adminByAdminUpdate;
       this.adminByAdminCreate = adminByAdminCreate;
       this.provinceName = provinceName;
       this.description = description;
       this.createDate = createDate;
       this.updateDate = updateDate;
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

    
    @Column(name="province_name", nullable=false)
    public Serializable getProvinceName() {
        return this.provinceName;
    }
    
    public void setProvinceName(Serializable provinceName) {
        this.provinceName = provinceName;
    }

    
    @Column(name="description")
    public Serializable getDescription() {
        return this.description;
    }
    
    public void setDescription(Serializable description) {
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




}

