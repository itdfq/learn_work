package Thread.Future;

/**
 * @Author GocChin
 * @Date 2021/7/26 11:03
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class ColdDishThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("凉菜准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
