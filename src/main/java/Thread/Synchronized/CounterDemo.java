package Thread.Synchronized;

/**
 * @Author GocChin
 * @Date 2021/7/19 14:54
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */

public class CounterDemo {
    long count = 0;

    public void add() {
        count++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--" + count);
    }
}