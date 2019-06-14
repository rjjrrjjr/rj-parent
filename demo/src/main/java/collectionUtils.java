import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * Created by 10064028 on 2018/4/9.
 */
public class collectionUtils {

    public static void main(String[] args) {
        List<String> list = null;
        System.out.println(CollectionUtils.isNotEmpty(list));
        list = new ArrayList<>();
        System.out.println(CollectionUtils.isNotEmpty(list));
        list.add("a");
        System.out.println(CollectionUtils.isNotEmpty(list));
    }
}
