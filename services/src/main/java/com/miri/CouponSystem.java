package com.miri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CouponSystem implements CouponClientFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(CouponSystem.class);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    private AdminFacade adminService;

    @Autowired
    private CompanyFacade companyService;

    @Autowired
    private CustomerFacade customerServices;


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

    @Scheduled(cron = "0 * * * * ?")
    void DailyCouponExpirationTask() {
            LOGGER.info("Cron Task :: Execution Time - {}", DATE_TIME_FORMATTER.format(LocalDateTime.now()));
            LocalDate today = LocalDate.now();
            //couponDAO.deleteByendDateBefore(today);
            // TODO: Thread
    }

    void shutdown() {
        //implement shutdown to DailyTask
    }

}
