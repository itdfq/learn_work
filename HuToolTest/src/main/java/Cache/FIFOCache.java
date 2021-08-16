package Cache;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.date.DateUnit;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 9:46
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:  先进先出
 */
public class FIFOCache {
    public static void main(String[] args) {
        Cache<String,String> fifoCache = CacheUtil.newFIFOCache(3);

//加入元素，每个元素可以设置其过期时长，DateUnit.SECOND.getMillis()代表每秒对应的毫秒数，在此为3秒
        fifoCache.put("key1", "value1", DateUnit.SECOND.getMillis() * 3);
        fifoCache.put("key2", "value2", DateUnit.SECOND.getMillis() * 3);
        fifoCache.put("key3", "value3", DateUnit.SECOND.getMillis() * 3);

//由于缓存容量只有3，当加入第四个元素的时候，根据FIFO规则，最先放入的对象将被移除
        fifoCache.put("key4", "value4", DateUnit.SECOND.getMillis() * 3);

//value1为null

        String value1 = fifoCache.get("key1");//null
        String value2 = fifoCache.get("key2");//null
        String value3 = fifoCache.get("key3");//null
        System.out.println("value1:"+value1);
        System.out.println("value2:"+value2);
        System.out.println("value3:"+value3);
    }
}
