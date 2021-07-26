package TimeUnit;

import java.util.concurrent.TimeUnit;

/**
 * @Author GocChin
 * @Date 2021/7/23 16:18
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:  TimeUnit是java.util.concurrent包下面的一个类，表示给定单元粒度的时间段
 *          主要作用：
 *                时间颗粒度转换
 *                          TimeUnit.DAYS          //天
 *                           TimeUnit.HOURS         //小时
                            TimeUnit.MINUTES       //分钟
                            TimeUnit.SECONDS       //秒
                             TimeUnit.MILLISECONDS  //毫秒
 *                延时
 *                      原来的写法： Thread.sleep( 5 * 1000 );
 *
 *                       TimeUnit.SECONDS.sleep( 5 );
 *                       System.out.println( "延时5秒，完成了");
 */
public class TimeUnitTest {
    public static void main(String[] args) {
        //1天有24个小时    1代表1天：将1天转化为小时
        System.out.println( TimeUnit.DAYS.toHours( 1 ) );
        //结果： 24


        //1小时有3600秒
        System.out.println( TimeUnit.HOURS.toSeconds( 1 ));
        //结果3600

        //把3天转化成小时
        System.out.println( TimeUnit.HOURS.convert( 3 , TimeUnit.DAYS ) );
        //结果是：72
    }
}
