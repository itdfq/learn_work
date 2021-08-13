package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author GocChin
 * @Date 2021/7/16 11:02
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
class MCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i=0;i<100;i++){
            sum+=i;
        }
        return sum;
    }
}
public class CallableTest {
    public static void main(String[] args) {
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(new MCallable());
        new Thread(integerFutureTask).start();
        Integer integer = null;
        try {
            integer=integerFutureTask.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
