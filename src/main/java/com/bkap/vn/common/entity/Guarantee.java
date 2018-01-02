package com.bkap.vn.common.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="group_role"
        ,schema="dbo"
        ,catalog="shop_online"
)
public class Guarantee {
    private int id;
    private String serial;
    private Date guaranteeFrom;
    private Date guaranteeTo;

    public Guarantee() {
    }

    public Guarantee(int id, String serial, Date guaranteeFrom, Date guaranteeTo) {
        this.id = id;
        this.serial = serial;
        this.guaranteeFrom = guaranteeFrom;
        this.guaranteeTo = guaranteeTo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "guarantee_from", length = 23)
    public Date getGuaranteeFrom() {
        return guaranteeFrom;
    }

    public void setGuaranteeFrom(Date guaranteeFrom) {
        this.guaranteeFrom = guaranteeFrom;
    }


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "guarantee_to", length = 23)
    public Date getGuaranteeTo() {
        return guaranteeTo;
    }

    public void setGuaranteeTo(Date guaranteeTo) {
        this.guaranteeTo = guaranteeTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guarantee)) return false;
        Guarantee guarantee = (Guarantee) o;
        return getId() == guarantee.getId() &&
                Objects.equals(getSerial(), guarantee.getSerial()) &&
                Objects.equals(getGuaranteeFrom(), guarantee.getGuaranteeFrom()) &&
                Objects.equals(getGuaranteeTo(), guarantee.getGuaranteeTo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getSerial(), getGuaranteeFrom(), getGuaranteeTo());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Guarantee{");
        sb.append("id=").append(id);
        sb.append(", serial='").append(serial).append('\'');
        sb.append(", guaranteeFrom=").append(guaranteeFrom);
        sb.append(", guaranteeTo=").append(guaranteeTo);
        sb.append('}');
        return sb.toString();
    }
}
