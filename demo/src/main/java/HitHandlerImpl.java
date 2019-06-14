import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-03-15 17:39
 */
public class HitHandlerImpl implements HitHandler {

    //记录最近一个小时之内的点击量
    private static volatile List<Integer> timeRecord = new ArrayList<>(3600);
    //最近一秒hit的时间
    private static volatile Long latestTime = 0L;
    //最近一秒hit后的点击量
    private static volatile int latestValue = 0;

    static {
        latestTime = System.currentTimeMillis() / 1000;
        for (int i = 0; i < 3600; i++) {
            timeRecord.add(0);
        }
    }

    @Override
    public void hit() {
        long currentTime = System.currentTimeMillis() / 1000 + 1;
        if (latestTime == currentTime){
            latestValue ++;
        }else {
            for (int i = 0; i < currentTime - latestTime; i++) {
                timeRecord.remove(0);
                timeRecord.add(0);
            }
            latestTime = currentTime;
            latestValue = 1;
        }
        timeRecord.set(3599, latestValue);
    }

    @Override
    public Count count() {
        long currentTime = System.currentTimeMillis() / 1000;
        if (currentTime != latestTime){
            for (int i = 0; i < currentTime - latestTime; i++) {
                timeRecord.remove(0);
                timeRecord.add(0);
            }
            latestTime = currentTime;
            latestValue = 0;
        }
        return new Count(timeRecord);
    }
}
