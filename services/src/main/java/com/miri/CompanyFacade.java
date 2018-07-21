package com.miri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CompanyFacade implements CouponClientFacade {

    @Autowired
    CompanyDAO companyDao;

    @Autowired
    CouponDAO couponDAO;

    public CompanyFacade() {
    }

    Collection<Coupon> getCouponByType(CouponType type) {
        return couponDAO.getCouponByType(type);
    }

    void createCoupon(Coupon coupon, Long comp_id) {
        Company company = companyDao.getCompany(comp_id);
        company.addCoupon(coupon);
        companyDao.updateCompany(company);
    }

    public CouponClientFacade login(String name, String password) {
        return null;
    }
}
