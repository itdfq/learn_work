import ch.hsr.geohash.GeoHash;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.io.GeohashUtils;

/**
 * @Author: GodChin
 * @Date: 2021/8/23 18:14
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:  使用GeohashUtils.encodeLatLon
 *
 * <dependency>
 *     <groupId>com.spatial4j</groupId>
 *     <artifactId>spatial4j</artifactId>
 *     <version>0.5</version>
 * </dependency>
 */
public class Test2 {
    public static void main(String[] args) {
        // 移动设备经纬度
        double lon1 = 116.3125333347639, lat1 = 39.98355521792821;
        // 商户经纬度
        double lon2 = 116.312528, lat2 = 39.983733;
        double lon3 = 116.312528, lat3 = 39.983633;
        SpatialContext geo = SpatialContext.GEO;
        double distance = geo.calcDistance(geo.makePoint(lon1, lat1), geo.makePoint(lon2, lat2)) * DistanceUtils.DEG_TO_KM;
        System.out.println(distance);// KM
//        System.out.println(distance *1000);
//        double distance1 = geo.calcDistance(geo.makePoint(lon1, lat1), geo.makePoint(lon3, lat3)) * DistanceUtils.DEG_TO_KM;
//        System.out.println(distance1*1000);
    }
}
