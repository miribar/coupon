package com.miri;

public enum CouponType {

    RESTAURANTS("rest"),       //like public static final ... (constant def)
    ELECTICITY("elec"),
    FOOD("food");
//    HEALTH,
//    SPORTS,
//    CAMPING,
//    TRAVELING,
//    FASION;

    private final String code;

    CouponType(String code) {      //constructor is private, like for singleton
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
