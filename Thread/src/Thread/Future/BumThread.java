package Thread.Future;

/**
 * @Author GocChin
 * @Date 2021/7/26 11:02
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class BumThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000*3);
            System.out.println("包子准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
