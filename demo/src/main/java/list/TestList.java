package list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Created by 10064028 on 2018/3/27.
 */
public class TestList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.remove(0);
    }

    @Test
    public void tt(){
        System.out.println("==================");
        List<Integer> list = new ArrayList<>();
        System.out.println(list.isEmpty());    }

    @Test
    public void testINT(){
        List<Object> list = Arrays.asList("1", 2);
        for (Object o : list) {
            System.out.println(4 > Integer.valueOf(o.toString()));
        }
    }

}
