package com.miri;

import com.miri.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Collection;

public interface CouponDAO extends JpaRepository<Coupon, Long> {

//    int createCoupon(Coupon coupon);
//    void removeCoupon(Coupon coupon);
//    void updateCoupon(Coupon coupon);

    @Query("select c from Coupon c where c.id = ?1")
    Coupon getCoupon(int id);

    @Query("select c from Coupon c")
    Collection<Coupon> getAllCoupons();

//    Collection<Coupon>getCouponByType(String couponType);
}
