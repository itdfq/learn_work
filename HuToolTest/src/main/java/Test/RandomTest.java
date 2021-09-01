package Test;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.LongStream;

/**
 * @Author: GodChin
 * @Date: 2021/8/24 9:35
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class RandomTest {
    public static void main(String[] args) {
      //经度
        String lon = randomLonLat(73.544735, 135.344735, 4.324735, 53.532124, "Lon");
        //纬度
        String lat = randomLonLat(73.544735, 135.344735, 4.324735, 53.532124, "lat");
        System.out.println(lon+"----"+lat);

    }

    /**
     * @Title: randomLonLat
     * @Description: 在矩形内随机生成经纬度
     * @param MinLon：最新经度  MaxLon： 最大经度   MinLat：最新纬度   MaxLat：最大纬度    type：设置返回经度还是纬度
     * @return
     * @throws
     */
    public static String randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat, String type) {
        Random random = new Random();
        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 小数后6位
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        if (type.equals("Lon")) {
            return lon;
        } else {
            return lat;
        }
    }
}
