package com.miri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface CustomerFacade {

    @Autowired
    CustomerDAO customerDao = null;

    void createCustomer(Customer customer);
    void removeCustomer(Customer customer);
    void updateCustomer(Customer customer);

    Customer getCustomer(Long id);
    Collection<Customer> getAllCustomers();
    Collection<Coupon> getCoupons();

    boolean login(String custName, String password);
}
