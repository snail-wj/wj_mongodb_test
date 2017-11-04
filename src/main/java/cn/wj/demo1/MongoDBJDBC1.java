package cn.wj.demo1;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * User: WJ
 * Date: 2017/11/4
 * 创建集合
 */
public class MongoDBJDBC1 {
    public static void main(String[] args) {
        try {
            // 连接到mongodb服务器
            MongoClient mongoClient = new MongoClient("67.216.215.4", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("connect to database successfully");
            mongoDatabase.createCollection("test");
            System.out.println("create collections successfully!");
        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
