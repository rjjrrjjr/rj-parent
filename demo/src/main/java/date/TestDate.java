package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 10064028 on 2018/1/24.
 */
public class TestDate {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        /*Calendar cal1 = Calendar.getInstance();
        System.out.println(sdf.format(cal1.getTime()));
        cal1.set(Calendar.MONTH, 0);
        cal1.set(Calendar.DAY_OF_MONTH, 32);
        System.out.println(sdf.format(cal1.getTime()));
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 0, 0, 0, 0);
        Date date = cal.getTime();
        */
        Calendar cal = Calendar.getInstance();
        Date time1 = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, 0);
        System.out.println(sdf.format(time1.getTime()));
        System.out.println(sdf.format(cal.getTime()));

        System.out.println("=======================================================");
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.set(Calendar.DAY_OF_MONTH, 0);
        System.out.println(sdf.format(instance.getTime()));
    }
}
