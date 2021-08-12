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

    public static void main(String[] args) {
        //获取处理器个数
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("处理器个数"+i);
        long l = Runtime.getRuntime().freeMemory();
        System.out.println("可用内存："+l);
        long l1 = Runtime.getRuntime().totalMemory();
        System.out.println("总的内存："+l1);
    }
}
