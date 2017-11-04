package cn.wj.demo1;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * User: WJ
 * Date: 2017/11/4
 * 删除第一个文档
 */
public class MongoDBJDBC6 {
    public static void main(String[] args) {
        try {
            // 连接到mongodb服务器
            MongoClient mongoClient = new MongoClient("67.216.215.4", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("collections test select successfuly");

            //删除符合条件的第一个文档
            collection.deleteOne(Filters.eq("likes",200));
            //删除所有符合条件的文档
            collection.deleteMany(Filters.eq("likes",200));
            //检索查看结果
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
