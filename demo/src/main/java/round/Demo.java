package round;

import java.text.DecimalFormat;

/**
 * Created by 10064028 on 2018/3/14.
 */
public class Demo {
    public static void main(String[] args) {
        byte a = 1;

        byte maxValue = Byte.MAX_VALUE;
        byte minValue = Byte.MIN_VALUE;
        System.out.println(maxValue + "++" + minValue);

        System.out.println(new DecimalFormat("#.00").format(3.141592654));

        System.out.println(Math.round(3.14159 * 100) * 0.01);
    }
}
