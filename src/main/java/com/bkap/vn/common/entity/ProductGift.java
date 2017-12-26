package com.bkap.vn.common.entity;
// Generated Dec 6, 2017 9:49:55 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * ProductGift generated by hbm2java
 */
@Entity
@Table(name="product_gift"
    ,schema="dbo"
    ,catalog="shop_online"
)
public class ProductGift  implements java.io.Serializable {


     private int id;

     private Gift gift;
     private Product product;
     private String description;
     private Date createDate;
     private Date updateDate;
    private Admin adminByAdminCreate;
    private Admin adminByAdminUpdate;
    public ProductGift() {
    }

	
    public ProductGift(int id, Gift gift, Product product) {
        this.id = id;
        this.gift = gift;
        this.product = product;
    }
    public ProductGift(int id, Admin adminByAdminCreate, Admin adminByAdminUpdate, Gift gift, Product product, String description, Date createDate, Date updateDate) {
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

     @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="create_date", length=23)
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="update_date", length=23)
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }




}


