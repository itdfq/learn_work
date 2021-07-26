package pause;

/**
 * @Author GocChin
 * @Date 2021/7/23 16:25
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:  在一个线程中调用另一个线程的interrupt()方法，即会向那个线程发出信号——线程中断状态已被设置。至于那个线程何去何从，由具体的代码实现决定。
 *
 * isInterrupted()，用来判断当前线程的中断状态(true or false)。
 * interrupted()是个Thread的static方法，用来恢复中断状态，名字起得额🙄。
 *
 * interrupt()不能中断在运行中的线程，它只能改变中断状态而已。
 *
 * 它可以迅速中断被阻塞的线程，抛出一个InterruptedException，把线程从阻塞状态中解救出来
 *
 */
public class Interrupt {
}
