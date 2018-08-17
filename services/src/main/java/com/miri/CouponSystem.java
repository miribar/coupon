package com.miri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Set;

@Service
public class CouponSystem implements CouponClientFacade {

    @Autowired
    private AdminFacade adminService;

//    public CouponSystem CouponSystem() {
//        return this.getInstance();
//    }

//    private CouponSystem getInstance() {
//        if (couponSystem == null)
//            return new CouponSystem();
//        else
//            return couponSystem;
//    }

    @Override
    public CouponClientFacade login(String name, String password, String clientType) {
        return null;
        //according to clientType, will return one of the facades
    }

    void dailyCouponExpirationTask() {
        adminService.dailyCouponExpirationTask();
    }

    void shutdown() {
        //implement shutdown to DailyTask
    }

}
