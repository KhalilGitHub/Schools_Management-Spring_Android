package org.hltic.sms_backend_rest.api.utilities.utils;

import java.math.BigDecimal;

public class BigDecimalCompute {
	
	static BigDecimal itemCost  = BigDecimal.ZERO;
    static BigDecimal result = BigDecimal.ZERO;

    public static BigDecimal compute(int intNumber, BigDecimal bgNumber)
    {
        itemCost  = bgNumber.multiply(new BigDecimal(intNumber));
        result = result.add(itemCost);
        return result;
    }
}