package Thread.Synchronized;

/**
 * @Author GocChin
 * @Date 2021/7/19 14:37
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: 计数器类
 */
public class Counter {
    long count = 0;
    /*
    //同步实例方法
    public synchronized void add() {
        count++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--" + count);
    }

     */
    /**
     * 同步代码块，使用本类
     */

    public void add(){
        //同步代码块
        synchronized(this){  //同步监视器(锁) 这里使用的是本类
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--" + count);
        }
    }






}


