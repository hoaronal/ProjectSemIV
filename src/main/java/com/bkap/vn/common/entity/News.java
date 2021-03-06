package com.bkap.vn.common.entity;
// Generated Dec 6, 2017 9:49:55 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * News generated by hbm2java
 */
@Entity
@Table(name="news"
    ,schema="dbo"
    ,catalog="shop_online"
)
public class News  implements java.io.Serializable {


     private int id;
     private Admin adminByAdminCreate;
     private Admin adminByAdminUpdate;
     private String title;
     private String description;
     private String imageLink;
     private String imageList;
     private Date createDate;
     private Date updateDate;

    public News() {
    }

	
    public News(int id, String title) {
        this.id = id;
        this.title = title;
    }
    public News(int id, Admin adminByAdminCreate, Admin adminByAdminUpdate, String title, String description, String imageLink, String imageList, Date createDate, Date updateDate) {
       this.id = id;
       this.adminByAdminCreate = adminByAdminCreate;
       this.adminByAdminUpdate = adminByAdminUpdate;
       this.title = title;
       this.description = description;
       this.imageLink = imageLink;
       this.imageList = imageList;
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

    
    @Column(name="title", nullable=false)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    
    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="image_link")
    public String getImageLink() {
        return this.imageLink;
    }
    
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    
    @Column(name="image_list")
    public String getImageList() {
        return this.imageList;
    }
    
    public void setImageList(String imageList) {
        this.imageList = imageList;
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


