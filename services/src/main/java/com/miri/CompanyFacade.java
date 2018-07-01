package com.miri;

import com.miri.Company;
import com.miri.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CompanyFacade implements CouponClientFacade {

    @Autowired
    CompanyDAO companyDao;

    public CompanyFacade() {
    }

    public void createCoupon(Coupon coupon) {
        companyDao.getCoupons();
    }

    public CouponClientFacade login(String name, String password) {
        return null;
    }
}
