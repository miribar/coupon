package com.miri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class CustomerFacade implements CouponClientFacade {

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    CouponDAO couponDAO;

    public CustomerFacade() {
    }

    GeneralResponse purchaseCoupon(Long custId, Long couponId) {
        //TODO: need to update amount of coupons left and verify coupon not purchased before and not expired
        Customer customer = customerDAO.getCustomer(custId);
        Coupon coupon = couponDAO.getCoupon(couponId);
        if (coupon.getAmount() == 0) {
            return new GeneralResponse("No coupons available!");
        }
        else if (LocalDate.now().isAfter(coupon.getEndDate())) {
            return new GeneralResponse("Coupon expired in " + coupon.getEndDate());
        }
        else if (customer.getCoupons().contains(coupon)) {
            return new GeneralResponse("Coupon already purchased!");
        }
        else {
            customer.addCoupon(coupon);
            coupon.setAmount(coupon.getAmount() - 1);
            customerDAO.updateCustomer(customer);
            couponDAO.updateCoupon(coupon);
            return new GeneralResponse("Coupon purchased successfully!");
        }
    }

    public CouponClientFacade login(String name, String password) {
        return null;
    }
}
