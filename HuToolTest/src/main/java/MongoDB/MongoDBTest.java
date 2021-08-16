package MongoDB;

import cn.hutool.db.nosql.mongo.MongoFactory;
import com.mongodb.client.MongoDatabase;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 11:14
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class MongoDBTest {
    public static void main(String[] args) {
//master slave 组成主从集群
        MongoDatabase db = MongoFactory.getDS("master", "slave").getDb("test");

    }
}
