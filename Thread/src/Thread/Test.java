package Thread;

/**
 * @Author GocChin
 * @Date 2021/7/16 10:58
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread = new Thread(ticket,"小明");
        Thread thread1 = new Thread(ticket,"小红");
        thread.start();
        thread1.start();
    }
}
