package com.bkap.vn.common.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Accessories {



    private int id;
    private Product productid;
    private String name;
    private String detail;

    private Date createDate;
    private Date updateDate;
    private Admin adminByAdminCreate;
    private Admin adminByAdminUpdate;

    public Accessories() {
    }


    public Accessories(int id , String name, String detail, Product productid) {
        this.id = id;
        this.productid = productid;
        this.name = name;
        this.detail = detail;
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
    @JoinColumn(name = "product_id", nullable = false)
    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "detail", nullable = false)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_create")
    public Admin getAdminByAdminCreate() {
        return this.adminByAdminCreate;
    }

    public void setAdminByAdminCreate(Admin adminByAdminCreate) {
        this.adminByAdminCreate = adminByAdminCreate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_update")
    public Admin getAdminByAdminUpdate() {
        return this.adminByAdminUpdate;
    }

    public void setAdminByAdminUpdate(Admin adminByAdminUpdate) {
        this.adminByAdminUpdate = adminByAdminUpdate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date", length = 23)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "update_date", length = 23)
    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
