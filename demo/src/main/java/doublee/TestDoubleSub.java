package doublee;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 10064028 on 2018/2/28.
 */
public class TestDoubleSub {

    public static void main(String[] args) {
        /*Double a =  1d;
        Double b = 3.6;
        Double c = a * b;
        System.out.println(c);

        Integer a1 = 2;
        Integer b1 = null;
        Integer c1 = a1+b1;
        System.out.println(c1);*/

        System.out.println("==============================");
        String a = "5%";
        if (a.contains("%")){
            System.out.println(Double.valueOf(a.replace("%", ""))/100D);
        }

        //System.out.println(Double.valueOf("5/100"));


        System.out.println("============================================");

        System.out.println(Math.floor(1.234));
        System.out.println((int) Math.floor(1.234));
        System.out.println((int)1.234D);

        System.out.println(new Date(0L));

        System.out.println("===================");

        Double countTimeD = Double.valueOf(43369);
        long timeStamp = (long) ((countTimeD - 25569) * 24 - 8) * 60 * 60 * 1000;
        Date countDate = new Date(timeStamp);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(countDate));

        System.out.println("-----------------------------------");
        System.out.println(Math.round(4.5));
        System.out.println(Math.round(3.5));
        System.out.println(Math.round(3.6));
        System.out.println(Math.round(4.6));

    }
}
