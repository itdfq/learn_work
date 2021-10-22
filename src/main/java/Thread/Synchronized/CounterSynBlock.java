package Thread.Synchronized;

/**
 * @Author GocChin
 * @Date 2021/7/19 14:57
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 *
 *  使用同步代码 synchronized(obj)  调用类 ，新建一个普通的Counter
 *  test3 调用
 *
 */
public class CounterSynBlock {
    //声明一个实例变量
    private CounterDemo counterDemo;
    CounterSynBlock(CounterDemo counterDemo){
        this. counterDemo= counterDemo;
    }
    public void add() {
        //同步的是Counter对象实例
        synchronized ( counterDemo) {
            counterDemo.add();
        }
    }
}
