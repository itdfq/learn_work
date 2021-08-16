package Cache;

import cn.hutool.cache.file.LFUFileCache;

import java.util.concurrent.TimeUnit;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 9:56
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:  文件缓存
 *       FileCache主要是将小文件以byte[]的形式缓存到内存中，减少文件的访问，以解决频繁读取文件引起的性能问题。
 */
public class FileCache {
    public static void main(String[] args) {
        //参数1：容量，能容纳的byte数
//参数2：最大文件大小，byte数，决定能缓存至少多少文件，大于这个值不被缓存直接读取
//参数3：超时。毫秒
        LFUFileCache cache = new LFUFileCache(1000, 500, 2000);
        byte[] bytes = cache.getFileBytes("d:/a.jpg");
    }
}
