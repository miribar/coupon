package com.miri;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String compName;
    private String password;
    private String email;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "COMPANY_COUPON",
            joinColumns = @JoinColumn(name = "COMP_ID"),         // this class
            inverseJoinColumns = @JoinColumn(name = "COUPON_ID") // the other class
    )
    private Collection<Coupon> coupons;

    public Company() {
    }

    public Company(Long id, String compName, String password, String email, Collection<Coupon> coupons) {
        this.id = id;
        this.compName = compName;
        this.password = password;
        this.email = email;
        this.coupons = coupons;
    }

    public Long getId() {
        return id;
    }

    String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(Collection<Coupon> coupons) {
        this.coupons = coupons;
    }

    void addCoupon(Coupon coupon) {
        this.coupons.add(coupon);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", compName='" + compName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", coupons=" + coupons +
                '}';
    }
}
