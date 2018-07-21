package com.miri;

import com.miri.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CouponDAO extends JpaRepository<Coupon, Long> {

//    void removeCoupon(Coupon coupon);
//    void updateCoupon(Coupon coupon);

    @Query("select c from Coupon c where c.id = ?1")
    Coupon getCoupon(Long id);

    @Query("select c from Coupon c")
    Collection<Coupon> getAllCoupons();

    @Query("select c from Coupon c where c.type = :type")
    public Collection<Coupon> getCouponByType(@Param("type") CouponType type);

    default Coupon createCoupon(Coupon coupon) {
        return this.save(coupon);

    }

//    Collection<Coupon>getCouponByType(String couponType);
}
