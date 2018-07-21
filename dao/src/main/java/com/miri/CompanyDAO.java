package com.miri;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CompanyDAO extends JpaRepository<Company, Long> {

    default void createCompany(Company company) throws ConstraintViolationException {
        this.save(company);
    }
//    void removeCompany(Company company);

    default void updateCompany(Company company) {
        this.save(company);
    }

    @Query("select c from Company c where c.id = ?1")
    Company getCompany(Long id);

    @Query("select c from Company c")
    Collection<Company> getAllCompanies();

    @Query("select c from Coupon c")
    Collection<Coupon> getCoupons();

//    boolean login(String compName, String password);
}
