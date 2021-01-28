package utils;

import java.math.BigDecimal;

public class DecimalUtils {

    public static double roundDecimalNumber(double value, int number) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(number, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }
}
