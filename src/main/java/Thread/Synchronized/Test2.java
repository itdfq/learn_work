package Thread.Synchronized;

/**
 * @Author GocChin
 * @Date 2021/7/19 14:40
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        //构造两个实例，让每个线程访问一个实例
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Thread threadA = new CounterThread( counter1);
        Thread threadB = new CounterThread( counter2);
        threadA.start();
        threadB.start();
    }
}
