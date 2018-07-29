package com.miri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController                               //For serving REST requests, all responses default format is JSON
@RequestMapping("/rest/api/")  		          //this creates the services main API endpoint
public class CompanyController {

    @Autowired
    private CompanyFacade companyService;

    @Autowired
    private CouponTypeConverter couponTypeConverter;


    @GetMapping("/getallcoupons")
    public Collection<Coupon> getAllCouponse() {
        return companyService.getAllCoupons();
    }

    @GetMapping("/getcouponsbytype/{comp_id}/{type}")
    public GeneralResponse getCouponsByType(@PathVariable("comp_id") Long comp_id, @PathVariable("type") String type) {
        CouponType couponType=couponTypeConverter.convertToEntityAttribute(type);
        try {
            return new GeneralResponse(companyService.getCouponsByType(comp_id, couponType));
        } catch (Exception e) {
            return new GeneralResponse(e);
        }
    }

    @PostMapping("/createcoupon/{comp_id}")
    public GeneralResponse createCoupon(@RequestBody Coupon coupon, @PathVariable("comp_id") Long comp_id) {
        try {
            companyService.createCoupon(coupon, comp_id);
            return new GeneralResponse("Coupon added successfully!");
        } catch (Exception e) {
            return new GeneralResponse(e);
        }

    }

    @DeleteMapping("/deletecoupon/{comp_id}/{coupon_id}")
    public void deleteCoupon(@PathVariable("comp_id") Long comp_id, @PathVariable("coupon_id") Long coupon_id) {
        companyService.removeCoupon(comp_id, coupon_id);
    }

}

