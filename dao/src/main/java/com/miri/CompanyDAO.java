package com.miri;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CompanyDAO extends JpaRepository<Company, Long> {

    default void createCompany(Company company){

    }
//    void removeCompany(Company company);
//    void updateCompany(Company company);

    @Query("select c from Company c where c.id = ?1")
    Company getCompany(Long id);

    @Query("select c from Company c")
    Collection<Company> getAllCompanies();

    @Query("select c from Coupon c")
    Collection<Coupon> getCoupons();

//    boolean login(String compName, String password);
}
