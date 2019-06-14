package j8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 10064028 on 2018/4/3.
 */
public class TestSort {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User(3L, "rj", 23),
                new User(1L, "jr", 24),
                new User(2L, "zx", 25),
                new User(6L, "qw", 26),
                new User(4L, "as", 27));
        System.out.println(users);

        List<Long> collect = users.stream().map(user -> user.getId()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
