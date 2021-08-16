package Cache;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.date.DateUnit;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 9:48
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: 最近最少未使用
 */
public class LRUCache {
    public static void main(String[] args) {
        Cache<String, String> lruCache = CacheUtil.newLRUCache(3);
//通过实例化对象创建
//LRUCache<String, String> lruCache = new LRUCache<String, String>(3);
        lruCache.put("key1", "value1", DateUnit.SECOND.getMillis() * 3);
        lruCache.put("key2", "value2", DateUnit.SECOND.getMillis() * 3);
        lruCache.put("key3", "value3", DateUnit.SECOND.getMillis() * 3);
        lruCache.get("key1");//使用时间推近
        lruCache.put("key4", "value4", DateUnit.SECOND.getMillis() * 3);

//由于缓存容量只有3，当加入第四个元素的时候，根据LRU规则，最近最少使用的将被移除（2被移除）
        String value1 = lruCache.get("key1");//null
        String value2 = lruCache.get("key2");//null
        String value3 = lruCache.get("key3");//null
        System.out.println("value1:"+value1);
        System.out.println("value2:"+value2);
        System.out.println("value3:"+value3);
    }
}
