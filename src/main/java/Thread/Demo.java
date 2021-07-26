package Thread;

/**
 * @Author GocChin
 * @Date 2021/7/23 15:47
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Demo implements Runnable{
    public static boolean flag = true;
    private String name;
    public Demo(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        if(flag) {
            System.out.println(name + ",起床");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ",上班");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ",下班");
            flag = !flag;
        }else {
            System.out.println(name + "想进来却进不来");
        }
    }
}
class TestDemo{
    public static void main(String[] args) {

    }
}
