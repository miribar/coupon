package com.miri;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface CouponDAO extends JpaRepository<Coupon, Long>{

    default void removeCoupon(Long coupon_id) {
        Coupon coupon = this.getCoupon(coupon_id);
        this.delete(coupon);
    }

    default void updateCoupon(Coupon coupon) {
        this.save(coupon);
    }

    @Query("select c from Coupon c where c.id = ?1")
    Coupon getCoupon(Long id);

    @Query("select c from Coupon c")
    Collection<Coupon> getAllCoupons();

    @Query("select c from Coupon c where c.type = :type")
    Collection<Coupon> getCouponByType(CouponType type);

}

//TODO: removeCoupon, also purchased by customers
