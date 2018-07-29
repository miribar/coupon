package com.miri;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Set;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

    default void createCustomer(Customer customer) {
        this.save(customer);
    }

//    void removeCustomer(Customer customer);

    default void updateCustomer(Customer customer) {
        this.save(customer);
    }

    @Query("select c from Customer c where c.id = ?1")
    Customer getCustomer(Long id);

    @Query("select c from Customer c")
    Collection<Customer> getAllCustomers();

    @Query("select c from Coupon c")
    Collection<Coupon> getCoupons();

    default void removeCoupon(Long coupon_id) {
        Collection<Customer> allCustomers = this.getAllCustomers();
        for (Customer customer:allCustomers) {
            Set<Coupon> customerCoupons = customer.getCoupons();
            for (Coupon coupon:customerCoupons) {
                if (coupon.getId().equals(coupon_id)) {
                    customerCoupons.remove(coupon);
                    break;
                }
            }
            customer.setCoupons(customerCoupons);
            this.save(customer);
        }
    }

//    boolean login(String custName, String password);
}

//TODO: removeCustomer (with coupons history) - where is history saved?
//TODO: revise getCoupons to return coupons for customer_id
