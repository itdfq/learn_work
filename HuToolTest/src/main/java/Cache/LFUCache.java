package Cache;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.date.DateUnit;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 9:43
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: 最少使用
 */
public class LFUCache {
    public static void main(String[] args) {
        Cache<String, String> lfuCache = CacheUtil.newLFUCache(3);
//通过实例化对象创建
//LFUCache<String, String> lfuCache = new LFUCache<String, String>(3);

        lfuCache.put("key1", "value1", DateUnit.SECOND.getMillis() * 3);
        lfuCache.get("key1");//使用次数+1
        lfuCache.put("key2", "value2", DateUnit.SECOND.getMillis() * 3);
        lfuCache.get("key2");
        lfuCache.get("key2");
        lfuCache.put("key3", "value3", DateUnit.SECOND.getMillis() * 3);
        lfuCache.put("key4", "value4", DateUnit.SECOND.getMillis() * 3);

//由于缓存容量只有3，当加入第四个元素的时候，根据LRU规则，最少使用的将被移除（2,3被移除）
        String value1 = lfuCache.get("key1");//null
        String value2 = lfuCache.get("key2");//null
        String value3 = lfuCache.get("key3");//null
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }
}
