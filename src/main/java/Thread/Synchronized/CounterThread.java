package Thread.Synchronized;

/**
 * @Author GocChin
 * @Date 2021/7/19 14:37
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class CounterThread extends Thread{
    protected Counter counter = null;
    public CounterThread( Counter counter) {
        this. counter = counter;
    }
    @Override
    public void run() {
        //用多个线程调用同步实例方法
        for ( int i = 0; i < 5; i++) {
            counter.add();
        }
    }

}
