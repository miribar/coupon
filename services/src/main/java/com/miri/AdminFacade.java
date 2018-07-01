package com.miri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AdminFacade implements CouponClientFacade {

    @Autowired
    CompanyDAO companyDAO;

    public AdminFacade() {
    }

    public Collection<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    public CouponClientFacade login(String name, String password) {
        return null;
    }
}
