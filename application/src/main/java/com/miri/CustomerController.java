package com.miri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController                               //For serving REST requests, all responses default format is JSON
@RequestMapping("/rest/api/")  		          //this creates the services main API endpoint
public class CustomerController {

    @Autowired
    private CustomerFacade customerServices;

    @Autowired
    private CompanyFacade companyService;

    @Autowired
    private AdminFacade adminService;

    @Autowired
    private CouponTypeConverter couponTypeConverter;

    @PostMapping("/purchasecoupon/{cust_id}/{coupon_id}")
    public void purchaseCoupon(@PathVariable("cust_id") Long custId, @PathVariable("coupon_Id") Long couponId) {
        customerServices.purchaseCoupon(custId, couponId);
    }
}
