package com.miri;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Service
public class AdminFacade implements CouponClientFacade {

    @Autowired
    CompanyDAO companyDAO;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    CouponDAO couponDAO;


    public AdminFacade() {
    }

    void createCompany(Company company) throws ConstraintViolationException {
        companyDAO.createCompany(company);
    }

    void updateCompany(Company company) {
        companyDAO.updateCompany(company);
    }

    void removeCompany(Company company) {
        Set<Coupon> companyCoupons = company.getCoupons();
        Collection<Customer> allCustomers = customerDAO.getAllCustomers();
        for (Coupon coupon:companyCoupons) {                      //for each company coupon
            for (Customer customer:allCustomers){                 //for each customer

                Set<Coupon> currCustomerCoupons=customer.getCoupons();  //get purchased coupons
                for (Coupon currCoupon:currCustomerCoupons){      //for each purchased coupon
                    if (Objects.equals(currCoupon.getId(), coupon.getId())){  //if coupon exists
                        currCustomerCoupons.remove(currCoupon);   //remove from customer coupons
                    }
                }
                customerDAO.save(customer);   //save the customer
            }
        }
        companyDAO.delete(company);  //will delete from company, coupon & company-coupon
    }

    Company getCompany(Long id) {
        return companyDAO.getCompany(id);
    }

    Collection<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    Customer getCustomer(Long cust_id) {
        return customerDAO.getCustomer(cust_id);
    }

    Collection<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    void createCustomer(Customer customer) {
        customerDAO.createCustomer(customer);

    }

    void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);

    }

    void removeCustomer(Long cust_id) {
        customerDAO.removeCustomer(cust_id);
        // REMOVE ALL RELATED COUPONS
    }

    public CouponClientFacade login(String name, String password, String clientType) {
        return null;
    }
}
