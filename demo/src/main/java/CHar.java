import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-01-18 17:05
 */
public class CHar {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("a");
        list.add("2");
        list.add("r");
        list.add("y");

        String str = "asd";
        char c = str.charAt(0);
        System.out.println(c);
        String s = new String(new char[]{c});
        System.out.println(s);
        String s1 = String.valueOf(c);

        System.out.println("=================");
        System.out.println(list.contains(c));
        System.out.println(list.contains(s));
        System.out.println(s1);

        System.out.println("===============================");

        //求“int radix”进制数“String s”的十进制数是多少
        String aa = "23456789";
        System.out.println(Integer.valueOf(aa, 11));
        System.out.println(Integer.valueOf(aa, 11));
        System.out.println(Integer.valueOf(aa, 11));

        System.out.println("======================---------------------------------");
        removeKDigits("3456442324654643242", 7);

    }

    private static void removeKDigits(String num, int k){
        //字符栈
        char[] charsStack = new char[num.length() - k];
        //栈顶
        int top = 0;

        for (int i = 0; i < num.length(); i ++){
            char data = num.charAt(i);

            //比较栈顶元素与当前元素大小，当前元素大则直接入栈，否则栈顶元素出栈，然后当前元素入栈
            while (k > 0 && top > 0 && data < charsStack[top - 1]){
                k --;
                top --;
            }

            charsStack[top ++] = data;
        }

        System.out.println(charsStack);
    }
}
