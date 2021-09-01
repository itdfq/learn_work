import ch.hsr.geohash.GeoHash;



/**
 * @Author: GodChin
 * @Date: 2021/8/23 17:24
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        // 根据经纬度生成GeoHash对象，参数分别是纬度、经度、GeoHash长度addrPosX: "120.120736"
        //addrPosY: "30.281351"
        GeoHash geoHash = GeoHash.withCharacterPrecision(30.274202, 119.979421, 9);
        System.out.println(geoHash.toBase32());
        System.out.println(geoHash.toString());
        System.out.println(geoHash.toBinaryString());

//        System.out.println(geoHash);
//        // 输出GeoHash值 12位
//        System.out.println(geoHash.toBase32());
//        //反编译
//        GeoHash geoHash1 = GeoHash.fromGeohashString(geoHash.toBase32());
//        System.out.println(geoHash1);

//        GeoHash geoHash1 = GeoHash.withCharacterPrecision(1, 2, 12);
//        GeoHash geoHash2 = GeoHash.withCharacterPrecision(9, 42, 12);
//
//        long l = GeoHash.stepsBetween(geoHash, geoHash1);
//        long l1 = GeoHash.stepsBetween(geoHash, geoHash2);
//        System.out.println(l);
//        System.out.println(l1);





    }
}
