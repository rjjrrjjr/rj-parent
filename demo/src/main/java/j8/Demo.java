package j8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 10064028 on 2018/3/16.
 */
public class Demo {

    public static void main(String[] args) {

        List<User> userList = Arrays.asList(new User(1l, "zhangsan", 60),
                new User(1l, "lisi", 80),
                new User(2l, "wangwu2", 50),
                new User(3l, "wangwu", 50),
                new User(4l, "zhangsan", 80));

        Stream<User> stream = userList.stream();

        //一个可以为null的容器对象
        Optional<User> user = stream.collect(Collectors.minBy(Comparator.comparingInt(User::getScore)));

        user.ifPresent(System.out::println);

        Double aDouble = userList.stream().collect(Collectors.averagingDouble(User::getScore));
        System.out.println(aDouble);

        System.out.println(userList.stream().collect(Collectors.summingInt(User::getScore)));

//        Stream<User> rStream = userList.stream().map(a -> {
//            if (a.getScore() > 60)
//                return a;
//            return null;
//        });
        userList.stream().filter(a->a.getScore()>=60).forEach(System.out::println);

        System.out.println("=======================");
        Map<Integer, Map<String, List<User>>> mapMap = userList.stream().collect(Collectors.groupingBy(User::getScore, Collectors.groupingBy(User::getName)));
        for (Map.Entry<Integer, Map<String, List<User>>> entry : mapMap.entrySet()){
            System.out.println(entry.getKey()+"++++++++++++++++++++++++++++"+entry.getValue());
        }

    }
}
