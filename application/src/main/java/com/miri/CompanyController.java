package com.miri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController                               //For serving REST requests, all responses default format is JSON
@RequestMapping("/rest/api/")  		          //this creates the services main API endpoint
public class CompanyController {

    @Autowired
    private CustomerFacade customerServices;

    @Autowired
    private CompanyFacade companyService;

    @Autowired
    private AdminFacade adminService;

    @Autowired
    private CouponTypeConverter couponTypeConverter;

    //==  Coupon endpoints  ==//

    @GetMapping("/getcouponbytype/{type}")
    public Collection<Coupon> getCouponByType(@PathVariable("type") String type) {
        CouponType couponType=couponTypeConverter.convertToEntityAttribute(type);
        return companyService.getCouponByType(couponType);
    }

    @PostMapping("/createcoupon/{comp_id}")
    public void createCoupon(@RequestBody Coupon coupon, @PathVariable("comp_id") Long comp_id) {
        companyService.createCoupon(coupon, comp_id);
    }

}
