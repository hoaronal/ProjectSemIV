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
 * ProductGift generated by hbm2java
 */
@Entity
@Table(name="product_gift"
    ,schema="dbo"
    ,catalog="shop_online"
)
public class ProductGift  implements Serializable {


     private int id;
     private Admin adminByAdminCreate;
     private Admin adminByAdminUpdate;
     private Gift gift;
     private Product product;
     private Serializable description;
     private Date createDate;
     private Date updateDate;

    public ProductGift() {
    }

	
    public ProductGift(int id, Gift gift, Product product) {
        this.id = id;
        this.gift = gift;
        this.product = product;
    }
    public ProductGift(int id, Admin adminByAdminCreate, Admin adminByAdminUpdate, Gift gift, Product product, Serializable description, Date createDate, Date updateDate) {
       this.id = id;
       this.adminByAdminCreate = adminByAdminCreate;
       this.adminByAdminUpdate = adminByAdminUpdate;
       this.gift = gift;
       this.product = product;
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
    @JoinColumn(name="admin_create")
    public Admin getAdminByAdminCreate() {
        return this.adminByAdminCreate;
    }
    
    public void setAdminByAdminCreate(Admin adminByAdminCreate) {
        this.adminByAdminCreate = adminByAdminCreate;
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
    @JoinColumn(name="gift_id", nullable=false)
    public Gift getGift() {
        return this.gift;
    }
    
    public void setGift(Gift gift) {
        this.gift = gift;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
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

