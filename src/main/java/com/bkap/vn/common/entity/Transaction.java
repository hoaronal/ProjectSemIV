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
 * Transaction generated by hbm2java
 */
@Entity
@Table(name="transaction"
    ,schema="dbo"
    ,catalog="shop_online"
)
public class Transaction  implements Serializable {


     private int id;
     private Admin adminByAdminCreate;
     private Admin adminByAdminUpdate;
     private int userId;
     private Serializable userName;
     private Serializable userEmail;
     private Serializable userPhone;
     private double amount;
     private Serializable payment;
     private Serializable paymentInfo;
     private Serializable message;
     private Serializable security;
     private Date createDate;
     private Date updateDate;

    public Transaction() {
    }

	
    public Transaction(int id, int userId, Serializable userName, Serializable userEmail, Serializable userPhone, double amount, Serializable payment) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.amount = amount;
        this.payment = payment;
    }
    public Transaction(int id, Admin adminByAdminCreate, Admin adminByAdminUpdate, int userId, Serializable userName, Serializable userEmail, Serializable userPhone, double amount, Serializable payment, Serializable paymentInfo, Serializable message, Serializable security, Date createDate, Date updateDate) {
       this.id = id;
       this.adminByAdminCreate = adminByAdminCreate;
       this.adminByAdminUpdate = adminByAdminUpdate;
       this.userId = userId;
       this.userName = userName;
       this.userEmail = userEmail;
       this.userPhone = userPhone;
       this.amount = amount;
       this.payment = payment;
       this.paymentInfo = paymentInfo;
       this.message = message;
       this.security = security;
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

    
    @Column(name="user_id", nullable=false)
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    @Column(name="user_name", nullable=false)
    public Serializable getUserName() {
        return this.userName;
    }
    
    public void setUserName(Serializable userName) {
        this.userName = userName;
    }

    
    @Column(name="user_email", nullable=false)
    public Serializable getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(Serializable userEmail) {
        this.userEmail = userEmail;
    }

    
    @Column(name="user_phone", nullable=false)
    public Serializable getUserPhone() {
        return this.userPhone;
    }
    
    public void setUserPhone(Serializable userPhone) {
        this.userPhone = userPhone;
    }

    
    @Column(name="amount", nullable=false, precision=53, scale=0)
    public double getAmount() {
        return this.amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }

    
    @Column(name="payment", nullable=false)
    public Serializable getPayment() {
        return this.payment;
    }
    
    public void setPayment(Serializable payment) {
        this.payment = payment;
    }

    
    @Column(name="payment_info")
    public Serializable getPaymentInfo() {
        return this.paymentInfo;
    }
    
    public void setPaymentInfo(Serializable paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    
    @Column(name="message")
    public Serializable getMessage() {
        return this.message;
    }
    
    public void setMessage(Serializable message) {
        this.message = message;
    }

    
    @Column(name="security")
    public Serializable getSecurity() {
        return this.security;
    }
    
    public void setSecurity(Serializable security) {
        this.security = security;
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

