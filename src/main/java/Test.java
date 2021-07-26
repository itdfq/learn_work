/**
 * @Author GocChin
 * @Date 2021/7/19 15:41
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Test {
    public static void f(Object obj){
        if(obj != null){
            System.out.println("do something");
        }
    }

    public static void test(String[] args){
        Object obj = null;
        f(obj);
    }
}
