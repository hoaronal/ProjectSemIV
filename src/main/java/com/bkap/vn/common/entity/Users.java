package com.bkap.vn.common.entity;
// Generated Aug 12, 2017 10:45:55 AM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "users"
        , schema = "dbo"
        , catalog = "shop_online"
)
public class Users implements Serializable {
    private int id;
    private Admin adminByAdminUpdate;
    private Admin adminByAdminCreate;
    @NotNull(message = "Tên người dùng không được để trống!")
    @Size(min = 5, max = 20,message = "Tên người dùng tối thiểu 5 kí tự, tối đa 20 kí tự!")
    private String username;
    @Size(min=8, max=20,message = "Mật khẩu tối thiểu 8 kí tự, tối đa 20 kí tự!")
    private String password;

    /*@NotNull
    @Pattern(regexp = "")*/
    private String email;
    private String phone;
    private Date birthday;
    private String address;
    private Date createDate;
    private Date updateDate;
    private byte activeStatus;
    private byte status;

    public Users() {
    }


    public Users(int id, String username, String password, String email, byte activeStatus, byte status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.activeStatus = activeStatus;
        this.status = status;
    }

    public Users(int id, Admin adminByAdminUpdate, Admin adminByAdminCreate, String username, String password, String email, String phone, Date birthday, String address, Date createDate, Date updateDate, byte activeStatus, byte status) {
        this.id = id;
        this.adminByAdminUpdate = adminByAdminUpdate;
        this.adminByAdminCreate = adminByAdminCreate;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.activeStatus = activeStatus;
        this.status = status;
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


    @Column(name = "username", nullable = false)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Temporal(TemporalType.TIMESTAMP)
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", length = 23)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
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


}

