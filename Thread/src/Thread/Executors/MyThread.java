package Thread.Executors;

/**
 * @Author GocChin
 * @Date 2021/7/26 10:04
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class MyThread extends Thread{
    private String name;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +"正在执行。。。");
    }
}
