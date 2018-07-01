package com.miri;

import com.miri.Coupon;
import com.miri.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

//    void createCustomer(Customer customer);
//    void removeCustomer(Customer customer);
//    void updateCustomer(Customer customer);

    @Query("select c from Customer c where c.id = ?1")
    Customer getCustomer(Long id);

    @Query("select c from Customer c")
    Collection<Customer> getAllCustomers();

    @Query("select c from Coupon c")
    Collection<Coupon> getCoupons();

//    boolean login(String custName, String password);
}
