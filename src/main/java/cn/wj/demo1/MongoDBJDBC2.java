package cn.wj.demo1;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * User: WJ
 * Date: 2017/11/4
 * 获取集合
 */
public class MongoDBJDBC2 {
    public static void main(String[] args) {
        try {
            // 连接到mongodb服务器
            MongoClient mongoClient = new MongoClient("67.216.215.4", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("collections test select successfuly");
        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
