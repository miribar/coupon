package com.miri;

import com.miri.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface CouponDAO extends JpaRepository<Coupon, Long>{

    default void removeCoupon(Long coupon_id) {
        Coupon coupon = this.getCoupon(coupon_id);
        this.delete(coupon);
    }

    default Coupon createCoupon(Coupon coupon) {
        return this.save(coupon);
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

//    Collection<Coupon>getCouponByType(String couponType);
}

//TODO: removeCoupon, also purchased by customers
