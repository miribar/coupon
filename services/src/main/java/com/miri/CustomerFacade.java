package com.miri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerFacade implements CouponClientFacade {

    @Autowired
    CustomerDAO customerDao;

    @Autowired
    CouponDAO couponDAO;

    public CustomerFacade() {
    }

    void purchaseCoupon(Long custId, Long couponId) {
        Customer customer = customerDao.getCustomer(custId);
        customer.addCoupon(couponDAO.getCoupon(couponId));
        customerDao.updateCustomer(customer);
    }

    public CouponClientFacade login(String name, String password) {
        return null;
    }
}
