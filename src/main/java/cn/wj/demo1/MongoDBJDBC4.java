package cn.wj.demo1;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

/**
 * User: WJ
 * Date: 2017/11/4
 * 检索所有文档
 */
public class MongoDBJDBC4 {
    public static void main(String[] args) {
        try {
            // 连接到mongodb服务器
            MongoClient mongoClient = new MongoClient("67.216.215.4", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("collections test select successfuly");

            //检索所有文档
            /**
             *1. 获取迭代器FindIterable<Document>
             *2. 获取游标MongoCursor<Document>
             *3. 通过游标遍历检索出的文档集合
             */
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while (mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
