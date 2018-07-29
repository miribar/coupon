package com.miri;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface CompanyDAO extends JpaRepository<Company, Long> {

    default void createCompany(Company company) throws ConstraintViolationException {
        this.save(company);
    }
//    void removeCompany(Company company);

    default void updateCompany(Company company) {
        this.save(company);
    }

    @Query("select c from Company c where c.id = ?1")
    Company getCompany(Long id);

    @Query("select c from Company c")
    Collection<Company> getAllCompanies();

    @Query("select c.coupons from Company c where c.id = ?1")
    Set<Coupon> getCoupons(Long comp_id);

    default void createCoupon(Long comp_id, Coupon coupon) {
        Company company = this.getCompany(comp_id);
        Set<Coupon> companyCoupons = company.getCoupons();
        companyCoupons.add(coupon);
        this.save(company);
    }

    default void removeCoupon(Long comp_id, Long coupon_id) {
        Set<Coupon> comp_coupons = this.getCoupons(comp_id);
        for (Coupon coupon:comp_coupons) {
            if(coupon.getId().equals(coupon_id)) {
                comp_coupons.remove(coupon);
                break;
            }
        }
        Company company = this.getCompany(comp_id);
        company.setCoupons(comp_coupons);
        this.save(company);
    }

//    boolean login(String compName, String password);
}

//TODO: removeCompany also from DB
//TODO: revise getCoupons to return coupons for company_id
