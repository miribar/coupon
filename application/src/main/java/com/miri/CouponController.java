package com.miri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController                               //For serving REST requests, all responses default format is JSON
@RequestMapping("/rest/api/")  		          //this creates the services main API endpoint
public class CouponController {

    @Autowired                                //this injects the PlayerServices into the controller, wires them together
    private CustomerDAO customerDAO;

    @Autowired
    private CompanyDAO companyDAO;

    @Autowired
    private CouponDAO couponDAO;

    //  Customer endpoints  //

    @GetMapping("/getcustomer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return customerDAO.getCustomer(id);
    }

    @GetMapping("/getallcustomers")
    public Collection<Customer> getCustomer() {
        return customerDAO.getAllCustomers();
    }

    //  Company endpoints  //


    //  Coupon endpoints  //


}
