package com.miri;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue
    Long id;
    String custName;
    String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CUSTOMER_COUPON",
            joinColumns = @JoinColumn(name = "CUST_ID"),         // this class
            inverseJoinColumns = @JoinColumn(name = "COUPON_ID") // the other class
    )
    Collection<Coupon> coupons;

    public Customer() {
    }

    public Customer(String custName, String password, Collection<Coupon> coupons) {
        this.custName = custName;
        this.password = password;
        this.coupons = coupons;
    }

    public Long getId() {
        return id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(Collection<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", custName='" + custName + '\'' +
                ", password='" + password + '\'' +
                ", coupons=" + coupons +
                '}';
    }
}
