package cn.wj.demo1;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

/**
 * User: WJ
 * Date: 2017/11/4
 * 插入文档
 */
public class MongoDBJDBC3 {
    public static void main(String[] args) {
        try {
            // 连接到mongodb服务器
            MongoClient mongoClient = new MongoClient("67.216.215.4", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("collections test select successfuly");

            //插入文档
            /**
             * 1.创建文档org.bson.Document 参数为key-value的格式
             * 2.创建文档集合List<Document>
             * 3.将文档集合插入数据库集合中mongoCollection.insertMany(List<Document>)插入单个文档可以用
             * mongCollection.insertOne(Document)
             */
            Document document = new Document("title", "MongoDB").
            append("description","databases").
            append("likes",100).
            append("by","Fly");
            ArrayList<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            System.out.println("文档插入successfully");
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
