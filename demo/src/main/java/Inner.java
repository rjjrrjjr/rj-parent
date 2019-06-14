/**非静态内部类不能含有任何静态数据或静态方法
 * @Description:
 * @author: ruanjin
 * @Date: 2019-03-01 16:48
 */
public class Inner extends B {

    private class II{
        //private static String a = "asd";

        /*private static String say(){
            return "";
        }*/


    }
}

interface A{
    String say();
}

class B{
    String say(){
        return "";
    }
}
