package com.miri;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CompanyFacade implements CouponClientFacade {

    @Autowired
    CompanyDAO companyDAO;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    CouponDAO couponDAO;

    public CompanyFacade() {
    }

    Collection<Coupon> getAllCoupons() {
        return couponDAO.getAllCoupons();
    }

    Collection<Coupon> getCouponsByType(Long comp_id, CouponType type) throws RuntimeException {
        Collection<Coupon> companyCoupons = companyDAO.getCoupons(comp_id);
            return companyCoupons.stream()
                    .filter(coupon -> coupon.getType().equals(type))
                    .collect(Collectors.toCollection(LinkedList::new));
    }

//    Collection<Coupon> getCouponsByPriceLimit(int price) {
//        return couponDAO.getCouponByPriceLimit(price);
//    }

//    Collection<Coupon> getCouponsByDateLimit(LocalDate date) {
//        return couponDAO.getCouponByDateLimit(date);
//    }

    void createCoupon(Coupon coupon, Long comp_id) throws ConstraintViolationException {
        companyDAO.createCoupon(comp_id, coupon);
    }

    void removeCoupon(Long comp_id, Long coupon_id) {
        companyDAO.removeCoupon(comp_id, coupon_id);
        customerDAO.removeCoupon(coupon_id);
        couponDAO.removeCoupon(coupon_id);
    }

    public CouponClientFacade login(String name, String password) {
        return null;
    }
}

