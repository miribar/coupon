package com.miri;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AdminFacade implements CouponClientFacade {

    @Autowired
    CompanyDAO companyDAO;

    @Autowired
    CustomerDAO customerDAO;

    public AdminFacade() {
    }

    void createCompany(Company company) throws ConstraintViolationException {
        companyDAO.createCompany(company);
    }

    void updateCompany(Company company) {
        companyDAO.updateCompany(company);
    }

//    void removeCompany(Company company) {
//        companyDAO.delete(company);
//    }

    Company getCompany(Long id) {
        return companyDAO.getCompany(id);
    }

    Collection<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    Collection<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public void createCustomer(Customer customer) {
        customerDAO.createCustomer(customer);

    }

    public CouponClientFacade login(String name, String password) {
        return null;
    }
}
