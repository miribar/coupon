package com.miri;

public enum CouponType {

    RESTAURANTS("r");
//    ELECTICITY,
//    FOOD,
//    HEALTH,
//    SPORTS,
//    CAMPING,
//    TRAVELING,
//    FASION;

    private final String code;

    CouponType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
