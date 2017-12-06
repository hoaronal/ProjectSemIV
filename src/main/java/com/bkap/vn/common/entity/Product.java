package com.bkap.vn.common.entity;
// Generated Aug 12, 2017 10:45:55 AM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product"
        , schema = "dbo"
        , catalog = "shop_online"
)
public class Product implements Serializable {


    private int id;
    private Category category;
    private String productName;
    private double price;
    private double discount;
    private String imageLink;
    private String imageList;
    private Double countView;
    private Date createDate;
    private Date updateDate;
    private String detail;
    private byte status;
    private Set<ProductGift> productGifts = new HashSet<ProductGift>(0);
    private Admin adminByAdminCreate;
    private Admin adminByAdminUpdate;

    public Product() {
    }


    public Product(int id, Category category, String productName, double price, double discount, byte status) {
        this.id = id;
        this.category = category;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.status = status;
    }

    public Product(int id, Admin adminByAdminCreate, Admin adminByAdminUpdate, Category category, String productName, double price, double discount, String imageLink, String imageList, Double countView, Date createDate, Date updateDate, String detail, byte status, Set<ProductGift> productGifts) {
        this.id = id;
        this.adminByAdminCreate = adminByAdminCreate;
        this.adminByAdminUpdate = adminByAdminUpdate;
        this.category = category;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.imageLink = imageLink;
        this.imageList = imageList;
        this.countView = countView;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.detail = detail;
        this.status = status;
        this.productGifts = productGifts;
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
    @JoinColumn(name = "admin_create")
    public Admin getAdminByAdminCreate() {
        return this.adminByAdminCreate;
    }

    public void setAdminByAdminCreate(Admin adminByAdminCreate) {
        this.adminByAdminCreate = adminByAdminCreate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_update")
    public Admin getAdminByAdminUpdate() {
        return this.adminByAdminUpdate;
    }

    public void setAdminByAdminUpdate(Admin adminByAdminUpdate) {
        this.adminByAdminUpdate = adminByAdminUpdate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Column(name = "product_name", nullable = false)
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    @Column(name = "price", nullable = false, precision = 53, scale = 0)
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Column(name = "discount", nullable = false, precision = 53, scale = 0)
    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }


    @Column(name = "image_link")
    public String getImageLink() {
        return this.imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }


    @Column(name = "image_list")
    public String getImageList() {
        return this.imageList;
    }

    public void setImageList(String imageList) {
        this.imageList = imageList;
    }


    @Column(name = "count_view", precision = 53, scale = 0)
    public Double getCountView() {
        return this.countView;
    }

    public void setCountView(Double countView) {
        this.countView = countView;
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


    @Column(name = "detail")
    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return this.status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    public Set<ProductGift> getProductGifts() {
        return this.productGifts;
    }

    public void setProductGifts(Set<ProductGift> productGifts) {
        this.productGifts = productGifts;
    }


}


