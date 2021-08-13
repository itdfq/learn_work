package Thread.Synchronized;

/**
 * @Author GocChin
 * @Date 2021/7/19 14:38
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        //构造一个含同步方法的对象实例
        Counter counter = new Counter();
        Thread threadA = new CounterThread( counter);
        Thread threadB = new CounterThread( counter);
        threadA.start();
        threadB.start();
    }
}
