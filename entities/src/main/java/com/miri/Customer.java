package com.miri;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String custName;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMER_COUPON",
            joinColumns = @JoinColumn(name = "CUST_ID"),         // this class
            inverseJoinColumns = @JoinColumn(name = "COUPON_ID") // the other class
    )
    //Collection<Coupon> coupons;                   //this is a general collection type
    private Set<Coupon> coupons = new HashSet<>();  //this type of collection will not allow duplications

    public Customer() {
    }

    public Customer(String custName, String password, Set<Coupon> coupons) {
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

    public Set<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(Set<Coupon> coupons) {
        this.coupons = coupons;
    }

    void addCoupon(Coupon coupon) {
        this.coupons.add(coupon);
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
