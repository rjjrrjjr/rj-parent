package str;

import java.util.StringTokenizer;

import org.junit.Test;

/**
 * Created by 10064028 on 2018/4/12.
 */
public class TestStr {
    public static void main(String[] args) {
        String str1 = "str01";
        String str2 = new String("str")+new String("01");
        String str12 = "str" + "01";
        //str2.intern();
        System.out.println(str2==str1);
        System.out.println(str12==str1);
        System.out.println("============================");
        String str3 = new String("str")+new String("01");
        String str4 = "str01";
        str4.intern();
        System.out.println(str3==str4);
    }

    @Test
    public void tt(){
        StringTokenizer stringTokenizer = new StringTokenizer("23;34;45;56;;45;;45;6");
        int i = 0;
        while (stringTokenizer.hasMoreTokens()){
            i++;
            String s = stringTokenizer.nextToken(";");
            System.out.println(s);
        }
        System.out.println(i);
    }
}
