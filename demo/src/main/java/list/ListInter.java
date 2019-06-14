package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-03-05 10:48
 */
public class ListInter {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("d");
        strings.add("c");
        strings.add("b");

        System.out.println(strings);

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            iterator.remove();
        }
        System.out.println(strings);

    }
}
