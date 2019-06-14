package 排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-02-23 16:30
 */
public class DynamicSort {

    private static int sum = 0;

    public static void main(String[] args) {
        sort1(0, 10, new ArrayList<>());
        System.out.println(sum);
        System.out.println("==========");
        System.out.println(sort2(10));
    }

    private static int sort2(int targetLever){
        if (targetLever == 1){
            return 1;
        }else if (targetLever == 2){
            return 2;
        }else {
            int a = 1;   //f(n-2)
            int b = 2;   //f(n-1)
            int temp = 0;
            int i = 3;
            while (i++ != targetLever + 1){
                temp = a + b;
                a = b;
                b = temp;
            }
            return temp;
        }
    }

    private static void sort1(int currentLever, int targetLever, List<Integer> step){
        if (currentLever + 1 == targetLever){
            step.add(1);
            print(step);
            step.remove(step.size() - 1);
        }else if (currentLever + 2 == targetLever){
            step.add(2);
            print(step);
            step.remove(step.size() - 1);
            step.add(1);
            step.add(1);
            print(step);
            step.remove(step.size() - 1);
            step.remove(step.size() - 1);
        }else {
            step.add(1);
            sort1(currentLever + 1, targetLever, step);
            step.remove(step.size() - 1);
            step.add(2);
            sort1(currentLever + 2, targetLever, step);
            step.remove(step.size() - 1);
        }
    }

    private static void print(List<Integer> step){
        System.out.print("[");
        for (Integer integer : step) {
            System.out.print(integer + " ");
        }
        System.out.println("]=======================");
        sum++;
    }
}
