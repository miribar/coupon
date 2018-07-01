package com.miri;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CouponTypeConverter implements AttributeConverter<CouponType, String> {

    @Override
    public String convertToDatabaseColumn(CouponType couponType) {
        return couponType.getCode();
    }

    @Override
    public CouponType convertToEntityAttribute(String dbData) {
        final CouponType[] values = CouponType.values();
        for (CouponType type : values) {
            if (type.getCode().equals(dbData)) {
                return type;
            }
        }
        return null;
    }
}
