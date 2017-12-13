package com.bkap.vn.common.entity;
// Generated Dec 6, 2017 9:49:55 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category"
        , schema = "dbo"
        , catalog = "shop_online"
)
public class Category implements java.io.Serializable {


    private int id;

    private Category category;
    private String name_category;
    private String description;
    private Date createDate;
    private Date updateDate;
    private Admin adminByAdminUpdate;
    private Admin adminByAdminCreate;
    private Set<Category> categories = new HashSet<Category>(0);
    private Set<Product> products = new HashSet<Product>(0);

    public Category() {
    }


    public Category(int id, String name_category) {
        this.id = id;
        this.name_category = name_category;
    }

    public Category(int id, Admin adminByAdminUpdate, Admin adminByAdminCreate, Category category, String name_category, String description, Date createDate, Date updateDate, Set<Category> categories, Set<Product> products) {
        this.id = id;
        this.adminByAdminUpdate = adminByAdminUpdate;
        this.adminByAdminCreate = adminByAdminCreate;
        this.category = category;
        this.name_category = name_category;
        this.description = description;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.categories = categories;
        this.products = products;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_update")
    public Admin getAdminByAdminUpdate() {
        return this.adminByAdminUpdate;
    }

    public void setAdminByAdminUpdate(Admin adminByAdminUpdate) {
        this.adminByAdminUpdate = adminByAdminUpdate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_create")
    public Admin getAdminByAdminCreate() {
        return this.adminByAdminCreate;
    }

    public void setAdminByAdminCreate(Admin adminByAdminCreate) {
        this.adminByAdminCreate = adminByAdminCreate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    @Column(name = "name_category", nullable = false)
    public String getName_category() {
        return this.name_category;
    }
    public void setName_category(String name_category) {
        this.name_category = name_category;
    }


    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }


}


