package geektime.mongodb.demo.mongojdbcdriver;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.BsonNull;
import org.bson.Document;
import org.bson.types.Decimal128;
import org.junit.Test;

import java.util.Arrays;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.lookup;

/**
 * 如果连接报错 首先要考虑的是jar包版本是否匹配的原因
 * https://www.runoob.com/mongodb/mongodb-java.html mongodb javaapi教程
 * https://juejin.im/entry/5b558403f265da0f6d72d7ae 如何遍历数据量亿级别的Mongo库
 * https://www.jianshu.com/p/de6dc0a67dc5 基于mongodb的复杂操作。
 *https://www.jianshu.com/p/baea1bce6de3  mongo学习笔记纯干货
 * 多条件查询 https://blog.csdn.net/working_hewei/article/details/84138291
 */
public class TestCRUD {

    private MongoClient getMongodbClient() {

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        return mongoClient;
    }

    @Test
    public void testCreateCollection() {

        MongoClient mongoClient = getMongodbClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mock");
        mongoDatabase.createCollection("Groups");
    }

    @Test
    public void testInsert() {

        MongoClient mongoClient = this.getMongodbClient();

        // 获取指定数据库
        MongoDatabase database = mongoClient.getDatabase("mock");

        // 获取指定集合
        MongoCollection<Document> collection = database.getCollection("Groups");

        Document doc = new Document("group_id", "1")
                .append("name", "Friends");

        collection.insertOne(doc);
        mongoClient.close();
    }

    @Test
    public void testFind() {

        MongoClient mongoClient = this.getMongodbClient();

        MongoDatabase mongoDatabase = mongoClient.getDatabase("mock");

        MongoCollection<Document> collections = mongoDatabase.getCollection("orders");

        BasicDBObject condition = new BasicDBObject();
        condition.put("userId", 439);
        FindIterable<Document> documentList = collections.find(condition);

        for (Document document : documentList) {

            if (document != null) {

                System.out.println(document.toString());
            }
        }
    }

    @Test
    public void testUpdate() {

        MongoClient mongoClient = this.getMongodbClient();

        // 获取指定数据库
        MongoDatabase database = mongoClient.getDatabase("mock");

        // 获取指定集合
        MongoCollection<Document> collection = database.getCollection("city");

        BasicDBObject param = new BasicDBObject();
        param.put("name", "上海");

        BasicDBObject newParam = new BasicDBObject();
        newParam.put("name", "上海");
        newParam.put("jiancheng", "SH");

        BasicDBObject updateParam = new BasicDBObject();
        updateParam.put("$set", newParam);
        collection.updateMany(param, updateParam);
    }

    /**
     * 用mongodb实现联合查询
     */
    @Test
    public void joinQuery() {

        MongoClient mongoClient = this.getMongodbClient();

        // 获取指定数据库
        MongoDatabase database = mongoClient.getDatabase("mock");

        // 获取指定集合 (大小写还是敏感的)
        AggregateIterable<Document> documents = database.getCollection("Contacts").aggregate(
                Arrays.asList(lookup("Groups", "group_ids", "group_id", "Groups"))
        );

        for(Document document : documents) {

            System.out.println(document.toJson());
        }
    }

    @Test
    public void testSum() {

        MongoClient mongoClient = this.getMongodbClient();

        // 获取指定数据库
        MongoDatabase database = mongoClient.getDatabase("mock");
        AggregateIterable<Document> documents = database.getCollection("orders").aggregate(Arrays.asList(group(new BsonNull(), sum("total", "$total"))));

        for(Document document : documents) {

            System.out.println(document.toJson());
            MongoCursor<Document> cursor = documents.iterator();
            while (cursor.hasNext()) {

                Document itemDoc = cursor.next();
                Decimal128 total = (Decimal128) itemDoc.get("total");
                System.out.println(total);
            }
        }

    }

    /**
     * 分页查询订单信息
     */
    @Test
    public void pageQuery() {

        MongoClient mongoClient = this.getMongodbClient();

        // 获取指定数据库
        MongoDatabase database = mongoClient.getDatabase("mock");

        database.getCollection("orders").find();
    }
}
