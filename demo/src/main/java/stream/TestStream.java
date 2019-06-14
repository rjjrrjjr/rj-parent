package stream;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-01-02 17:36
 */
public class TestStream {
    public static void main(String[] args) {
        People rj = new People("rj");
        People jr = new People("jr");
        ArrayList<People> people = new ArrayList<>();
        people.add(rj);
        people.add(jr);

        Stream<People> stream = people.stream();

        stream.collect(Collectors.toList()).forEach(System.out::println);

        stream.filter(tt -> tt.getName().equals("rj")).collect(Collectors.toList()).forEach(System.out::println);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class People{
    private String name;
}
