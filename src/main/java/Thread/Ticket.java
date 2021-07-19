package Thread;

/**
 * @Author GocChin
 * @Date 2021/7/16 10:55
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Ticket implements Runnable{
    private int num = 0;
    private int count = 10;
    boolean flag = false;


    @Override
    public void run() {
        while (true) {
            synchronized (this){
                if (count <= 0) {
                    break;
                }
                num++;
                count--;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("显示出票信息："+Thread.currentThread().getName()+"抢到第："+num+"张票，剩余"+count+"票");
            }

        }
    }
}
