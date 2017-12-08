package com.bkap.vn.common.entity;
// Generated Dec 6, 2017 9:49:55 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Admin generated by hbm2java
 */
@Entity
@Table(name = "admin"
        , schema = "dbo"
        , catalog = "shop_online"
)
public class Admin implements java.io.Serializable {


    private int id;
    private String account;
    private String password;
    private String email;
    private String phone;
    private Date birthday;
    private String address;
    private Integer adminCreate;
    private Integer adminUpdate;
    private Date createDate;
    private Date updateDate;
    private byte activeStatus;
    private byte status;
    private Set<RoleByGroupRole> roleByGroupRolesForAdminCreate = new HashSet<RoleByGroupRole>(0);
    private Set<Users> usersesForAdminCreate = new HashSet<Users>(0);
    private Set<OrderDetail> orderDetailsForAdminCreate = new HashSet<OrderDetail>(0);
    private Set<Product> productsForAdminCreate = new HashSet<Product>(0);
    private Set<Role> rolesForAdminCreate = new HashSet<Role>(0);
    private Set<RoleByGroupRole> roleByGroupRolesForAdminUpdate = new HashSet<RoleByGroupRole>(0);
    private Set<Users> usersesForAdminUpdate = new HashSet<Users>(0);
    private Set<Order> ordersForAdminUpdate = new HashSet<Order>(0);
    private Set<GroupRole> groupRolesForAdminUpdate = new HashSet<GroupRole>(0);
    private Set<News> newsesForAdminCreate = new HashSet<News>(0);
    private Set<HistoryAction> historyActions = new HashSet<HistoryAction>(0);
    private Set<ProductGift> productGiftsForAdminCreate = new HashSet<ProductGift>(0);
    private Set<Product> productsForAdminUpdate = new HashSet<Product>(0);
    private Set<OrderDetail> orderDetailsForAdminUpdate = new HashSet<OrderDetail>(0);
    private Set<ProductGift> productGiftsForAdminUpdate = new HashSet<ProductGift>(0);
    private Set<Category> categoriesForAdminUpdate = new HashSet<Category>(0);
    private Set<Province> provincesForAdminUpdate = new HashSet<Province>(0);
    private Set<News> newsesForAdminUpdate = new HashSet<News>(0);
    private Set<Transaction> transactionsForAdminCreate = new HashSet<Transaction>(0);
    private Set<Transaction> transactionsForAdminUpdate = new HashSet<Transaction>(0);
    private Set<Order> ordersForAdminCreate = new HashSet<Order>(0);
    private Set<Gift> giftsForAdminCreate = new HashSet<Gift>(0);
    private Set<Role> rolesForAdminUpdate = new HashSet<Role>(0);
    private Set<Gift> giftsForAdminUpdate = new HashSet<Gift>(0);
    private Set<Category> categoriesForAdminCreate = new HashSet<Category>(0);
    private Set<Province> provincesForAdminCreate = new HashSet<Province>(0);
    private Set<GroupRole> groupRolesForAdminCreate = new HashSet<GroupRole>(0);

    public Admin() {
    }


    public Admin(int id, String account, String password, String email, byte activeStatus, byte status) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
        this.activeStatus = activeStatus;
        this.status = status;
    }

    public Admin(int id, String account, String password, String email, String phone, Date birthday, String address, Integer adminCreate, Integer adminUpdate, Date createDate, Date updateDate, byte activeStatus, byte status, Set<RoleByGroupRole> roleByGroupRolesForAdminCreate, Set<Users> usersesForAdminCreate, Set<OrderDetail> orderDetailsForAdminCreate, Set<Product> productsForAdminCreate, Set<Role> rolesForAdminCreate, Set<RoleByGroupRole> roleByGroupRolesForAdminUpdate, Set<Users> usersesForAdminUpdate, Set<Order> ordersForAdminUpdate, Set<GroupRole> groupRolesForAdminUpdate, Set<News> newsesForAdminCreate, Set<HistoryAction> historyActions, Set<ProductGift> productGiftsForAdminCreate, Set<Product> productsForAdminUpdate, Set<OrderDetail> orderDetailsForAdminUpdate, Set<ProductGift> productGiftsForAdminUpdate, Set<Category> categoriesForAdminUpdate, Set<Province> provincesForAdminUpdate, Set<News> newsesForAdminUpdate, Set<Transaction> transactionsForAdminCreate, Set<Transaction> transactionsForAdminUpdate, Set<Order> ordersForAdminCreate, Set<Gift> giftsForAdminCreate, Set<Role> rolesForAdminUpdate, Set<Gift> giftsForAdminUpdate, Set<Category> categoriesForAdminCreate, Set<Province> provincesForAdminCreate, Set<GroupRole> groupRolesForAdminCreate) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.adminCreate = adminCreate;
        this.adminUpdate = adminUpdate;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.activeStatus = activeStatus;
        this.status = status;
        this.roleByGroupRolesForAdminCreate = roleByGroupRolesForAdminCreate;
        this.usersesForAdminCreate = usersesForAdminCreate;
        this.orderDetailsForAdminCreate = orderDetailsForAdminCreate;
        this.productsForAdminCreate = productsForAdminCreate;
        this.rolesForAdminCreate = rolesForAdminCreate;
        this.roleByGroupRolesForAdminUpdate = roleByGroupRolesForAdminUpdate;
        this.usersesForAdminUpdate = usersesForAdminUpdate;
        this.ordersForAdminUpdate = ordersForAdminUpdate;
        this.groupRolesForAdminUpdate = groupRolesForAdminUpdate;
        this.newsesForAdminCreate = newsesForAdminCreate;
        this.historyActions = historyActions;
        this.productGiftsForAdminCreate = productGiftsForAdminCreate;
        this.productsForAdminUpdate = productsForAdminUpdate;
        this.orderDetailsForAdminUpdate = orderDetailsForAdminUpdate;
        this.productGiftsForAdminUpdate = productGiftsForAdminUpdate;
        this.categoriesForAdminUpdate = categoriesForAdminUpdate;
        this.provincesForAdminUpdate = provincesForAdminUpdate;
        this.newsesForAdminUpdate = newsesForAdminUpdate;
        this.transactionsForAdminCreate = transactionsForAdminCreate;
        this.transactionsForAdminUpdate = transactionsForAdminUpdate;
        this.ordersForAdminCreate = ordersForAdminCreate;
        this.giftsForAdminCreate = giftsForAdminCreate;
        this.rolesForAdminUpdate = rolesForAdminUpdate;
        this.giftsForAdminUpdate = giftsForAdminUpdate;
        this.categoriesForAdminCreate = categoriesForAdminCreate;
        this.provincesForAdminCreate = provincesForAdminCreate;
        this.groupRolesForAdminCreate = groupRolesForAdminCreate;
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


    @Column(name = "account", nullable = false)
    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    @Column(name = "password", nullable = false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Column(name = "email", nullable = false)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name = "phone")
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", length = 23)
    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Column(name = "address")
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Column(name = "admin_create")
    public Integer getAdminCreate() {
        return this.adminCreate;
    }

    public void setAdminCreate(Integer adminCreate) {
        this.adminCreate = adminCreate;
    }


    @Column(name = "admin_update")
    public Integer getAdminUpdate() {
        return this.adminUpdate;
    }

    public void setAdminUpdate(Integer adminUpdate) {
        this.adminUpdate = adminUpdate;
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


    @Column(name = "active_status", nullable = false)
    public byte getActiveStatus() {
        return this.activeStatus;
    }

    public void setActiveStatus(byte activeStatus) {
        this.activeStatus = activeStatus;
    }


    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return this.status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<RoleByGroupRole> getRoleByGroupRolesForAdminCreate() {
        return this.roleByGroupRolesForAdminCreate;
    }

    public void setRoleByGroupRolesForAdminCreate(Set<RoleByGroupRole> roleByGroupRolesForAdminCreate) {
        this.roleByGroupRolesForAdminCreate = roleByGroupRolesForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<Users> getUsersesForAdminCreate() {
        return this.usersesForAdminCreate;
    }

    public void setUsersesForAdminCreate(Set<Users> usersesForAdminCreate) {
        this.usersesForAdminCreate = usersesForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<OrderDetail> getOrderDetailsForAdminCreate() {
        return this.orderDetailsForAdminCreate;
    }

    public void setOrderDetailsForAdminCreate(Set<OrderDetail> orderDetailsForAdminCreate) {
        this.orderDetailsForAdminCreate = orderDetailsForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<Product> getProductsForAdminCreate() {
        return this.productsForAdminCreate;
    }

    public void setProductsForAdminCreate(Set<Product> productsForAdminCreate) {
        this.productsForAdminCreate = productsForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<Role> getRolesForAdminCreate() {
        return this.rolesForAdminCreate;
    }

    public void setRolesForAdminCreate(Set<Role> rolesForAdminCreate) {
        this.rolesForAdminCreate = rolesForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<RoleByGroupRole> getRoleByGroupRolesForAdminUpdate() {
        return this.roleByGroupRolesForAdminUpdate;
    }

    public void setRoleByGroupRolesForAdminUpdate(Set<RoleByGroupRole> roleByGroupRolesForAdminUpdate) {
        this.roleByGroupRolesForAdminUpdate = roleByGroupRolesForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<Users> getUsersesForAdminUpdate() {
        return this.usersesForAdminUpdate;
    }

    public void setUsersesForAdminUpdate(Set<Users> usersesForAdminUpdate) {
        this.usersesForAdminUpdate = usersesForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<Order> getOrdersForAdminUpdate() {
        return this.ordersForAdminUpdate;
    }

    public void setOrdersForAdminUpdate(Set<Order> ordersForAdminUpdate) {
        this.ordersForAdminUpdate = ordersForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<GroupRole> getGroupRolesForAdminUpdate() {
        return this.groupRolesForAdminUpdate;
    }

    public void setGroupRolesForAdminUpdate(Set<GroupRole> groupRolesForAdminUpdate) {
        this.groupRolesForAdminUpdate = groupRolesForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<News> getNewsesForAdminCreate() {
        return this.newsesForAdminCreate;
    }

    public void setNewsesForAdminCreate(Set<News> newsesForAdminCreate) {
        this.newsesForAdminCreate = newsesForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "admin")
    public Set<HistoryAction> getHistoryActions() {
        return this.historyActions;
    }

    public void setHistoryActions(Set<HistoryAction> historyActions) {
        this.historyActions = historyActions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<ProductGift> getProductGiftsForAdminCreate() {
        return this.productGiftsForAdminCreate;
    }

    public void setProductGiftsForAdminCreate(Set<ProductGift> productGiftsForAdminCreate) {
        this.productGiftsForAdminCreate = productGiftsForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<Product> getProductsForAdminUpdate() {
        return this.productsForAdminUpdate;
    }

    public void setProductsForAdminUpdate(Set<Product> productsForAdminUpdate) {
        this.productsForAdminUpdate = productsForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<OrderDetail> getOrderDetailsForAdminUpdate() {
        return this.orderDetailsForAdminUpdate;
    }

    public void setOrderDetailsForAdminUpdate(Set<OrderDetail> orderDetailsForAdminUpdate) {
        this.orderDetailsForAdminUpdate = orderDetailsForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<ProductGift> getProductGiftsForAdminUpdate() {
        return this.productGiftsForAdminUpdate;
    }

    public void setProductGiftsForAdminUpdate(Set<ProductGift> productGiftsForAdminUpdate) {
        this.productGiftsForAdminUpdate = productGiftsForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<Category> getCategoriesForAdminUpdate() {
        return this.categoriesForAdminUpdate;
    }

    public void setCategoriesForAdminUpdate(Set<Category> categoriesForAdminUpdate) {
        this.categoriesForAdminUpdate = categoriesForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<Province> getProvincesForAdminUpdate() {
        return this.provincesForAdminUpdate;
    }

    public void setProvincesForAdminUpdate(Set<Province> provincesForAdminUpdate) {
        this.provincesForAdminUpdate = provincesForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<News> getNewsesForAdminUpdate() {
        return this.newsesForAdminUpdate;
    }

    public void setNewsesForAdminUpdate(Set<News> newsesForAdminUpdate) {
        this.newsesForAdminUpdate = newsesForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<Transaction> getTransactionsForAdminCreate() {
        return this.transactionsForAdminCreate;
    }

    public void setTransactionsForAdminCreate(Set<Transaction> transactionsForAdminCreate) {
        this.transactionsForAdminCreate = transactionsForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<Transaction> getTransactionsForAdminUpdate() {
        return this.transactionsForAdminUpdate;
    }

    public void setTransactionsForAdminUpdate(Set<Transaction> transactionsForAdminUpdate) {
        this.transactionsForAdminUpdate = transactionsForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<Order> getOrdersForAdminCreate() {
        return this.ordersForAdminCreate;
    }

    public void setOrdersForAdminCreate(Set<Order> ordersForAdminCreate) {
        this.ordersForAdminCreate = ordersForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<Gift> getGiftsForAdminCreate() {
        return this.giftsForAdminCreate;
    }

    public void setGiftsForAdminCreate(Set<Gift> giftsForAdminCreate) {
        this.giftsForAdminCreate = giftsForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<Role> getRolesForAdminUpdate() {
        return this.rolesForAdminUpdate;
    }

    public void setRolesForAdminUpdate(Set<Role> rolesForAdminUpdate) {
        this.rolesForAdminUpdate = rolesForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminUpdate")
    public Set<Gift> getGiftsForAdminUpdate() {
        return this.giftsForAdminUpdate;
    }

    public void setGiftsForAdminUpdate(Set<Gift> giftsForAdminUpdate) {
        this.giftsForAdminUpdate = giftsForAdminUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<Category> getCategoriesForAdminCreate() {
        return this.categoriesForAdminCreate;
    }

    public void setCategoriesForAdminCreate(Set<Category> categoriesForAdminCreate) {
        this.categoriesForAdminCreate = categoriesForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<Province> getProvincesForAdminCreate() {
        return this.provincesForAdminCreate;
    }

    public void setProvincesForAdminCreate(Set<Province> provincesForAdminCreate) {
        this.provincesForAdminCreate = provincesForAdminCreate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminByAdminCreate")
    public Set<GroupRole> getGroupRolesForAdminCreate() {
        return this.groupRolesForAdminCreate;
    }

    public void setGroupRolesForAdminCreate(Set<GroupRole> groupRolesForAdminCreate) {
        this.groupRolesForAdminCreate = groupRolesForAdminCreate;
    }


}


