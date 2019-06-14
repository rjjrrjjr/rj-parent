import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-03-15 17:34
 */
public interface HitHandler {
    void hit();

    Count count();
}

class Count{
    //最近10秒平均点击量
    private int averHitLatestTenSecond;
    //最近10分钟平均点击量
    private int averHitLatestTenminute;
    //最近60分钟平均点击量
    private int averHitLatestOneHour;
    //最近10秒点击量
    private List<Integer> latestTenSecondHitList;

    public Count() {
    }

    public Count(List<Integer> timeRecord) {
        this.averHitLatestTenSecond = timeRecord.stream().skip(3590).reduce((item1, item2) -> item1 + item2).get() / 10;
        this.averHitLatestTenminute = timeRecord.stream().skip(3000).reduce((item1, item2) -> item1 + item2).get() / 600;
        this.averHitLatestOneHour = timeRecord.stream().reduce((item1, item2) -> item1 + item2).get() / 3600;
        this.latestTenSecondHitList = timeRecord.stream().skip(3590).collect(Collectors.toList());
    }

    public int getAverHitLatestTenSecond() {
        return averHitLatestTenSecond;
    }

    public void setAverHitLatestTenSecond(int averHitLatestTenSecond) {
        this.averHitLatestTenSecond = averHitLatestTenSecond;
    }

    public int getAverHitLatestTenminute() {
        return averHitLatestTenminute;
    }

    public void setAverHitLatestTenminute(int averHitLatestTenminute) {
        this.averHitLatestTenminute = averHitLatestTenminute;
    }

    public int getAverHitLatestOneHour() {
        return averHitLatestOneHour;
    }

    public void setAverHitLatestOneHour(int averHitLatestOneHour) {
        this.averHitLatestOneHour = averHitLatestOneHour;
    }

    public List<Integer> getLatestTenSecondHitList() {
        return latestTenSecondHitList;
    }

    public void setLatestTenSecondHitList(List<Integer> latestTenSecondHitList) {
        this.latestTenSecondHitList = latestTenSecondHitList;
    }
}

