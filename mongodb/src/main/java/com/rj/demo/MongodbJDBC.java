package com.rj.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.QueryBuilder;
import com.mongodb.QueryOperators;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * Created by 10064028 on 2018/2/6.
 */
public class MongodbJDBC {

    public static void main(String[] args) {
        // 简单直接的连接数据库，默认为本机地址localhost，端口号27017
        // MongoClient mongoClient = new MongoClient();
        /*MongoClient mongoClient = new MongoClient(
                Arrays.asList(
                new ServerAddress("192.168.49.128", 12345),
                new ServerAddress("192.168.49.128", 123456),
                new ServerAddress("192.168.49.128", 1234567)));*/
        // 或者使用连接字符串
        /*MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017,localhost:27018,localhost:27019");
        MongoClient mongoClient = new MongoClient(connectionString);*/
        MongoClient mongoClient = new MongoClient("192.168.49.128", 12345);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("rjdb");
        System.out.println(mongoDatabase);
        System.out.println("connect to mongodb success");
        MongoCollection<Document> user = mongoDatabase.getCollection("rj_collection");

//        Document document = new Document("name", "mongodb").append("type", "database").append("count", 1).append("info", new Document("x", 203).append("y", 102));
//        user.insertOne(document);
//
//        ArrayList<Document> docs = new ArrayList<>();
//        for (int i = 6; i < 100; i++){
//            Document doc = new Document("name", "rj_" + i).append("age", (i + 17)).append("rj", new Document("X", (i + 100)).append("Y", (i - 100)));
//            docs.add(doc);
//        }
//        user.insertMany(docs);

        System.out.println(user.count());
        Document first = user.find().first();
        System.out.println(first.toJson());
        System.out.println("------------------------------------------------");

        MongoCursor<Document> iterator = user.find().iterator();
        while (iterator.hasNext()){
            Document next = iterator.next();
            System.out.println(next.toJson());
        }
        iterator.close();
        System.out.println("------------------------------------------------");

        Document age = user.find(eq("age", 20)).first();
        System.out.println(age.toJson());
        System.out.println("=======================================================");

        MongoCursor<Document> iterator1 = user.find(lte("age", 100)).iterator();
        while (iterator1.hasNext()){
            Document next = iterator1.next();
            System.out.println(next.toJson());
        }
        System.out.println("=======================================================");

        MongoCursor<Document> name = user.find(ne("name", "rj")).iterator();
        while (name.hasNext()){
            System.out.println(name.next().toJson());
        }
        System.out.println("-------------------------------------------------------");

        MongoCursor<Document> age1 = user.find(new BasicDBObject("age", new BasicDBObject(QueryOperators.IN, new int[]{20, 21, 22}))).iterator();
        while (age1.hasNext()){
            System.out.println(age1.next().toJson());
        }
        System.out.println("===============================================================");

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("age", new BasicDBObject("$gt", 110));
        basicDBObject.put("rj.X", new BasicDBObject("$gte", 195));
        basicDBObject.put("rj.Y", new BasicDBObject("$gte", -2));
        MongoCursor<Document> iterator2 = user.find(basicDBObject).iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next().toJson());
        }
        System.out.println("=--------------------------------------------------------------------------------------");

        MongoCursor<Document> iterator3 = user.find(new BasicDBObject(QueryOperators.AND, new BasicDBObject[]{
                new BasicDBObject("age", new BasicDBObject("$gt", 110)),
                new BasicDBObject(QueryOperators.OR, new BasicDBObject[]{
                        new BasicDBObject("rj.X", new BasicDBObject("$lt", 195)),
                        new BasicDBObject("rj.Y", new BasicDBObject("$gt", -2))
                })
        })).iterator();
        while (iterator3.hasNext()){
            System.out.println(iterator3.next().toJson());
        }
        System.out.println("========================++++++++++++++++++++++++++++++");

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.and("age").greaterThan(110);
        //queryBuilder.and("name").is("rj_95");
        MongoCursor<Document> iterator4 = user.find((Bson) queryBuilder.get()).sort(new BasicDBObject("rj.X", -1)).iterator();
        while (iterator4.hasNext()){
            System.out.println(iterator4.next().toJson());
        }
        System.out.println("-----------------------------------------------------");

        MongoCursor<Document> iterator5 = user.find(new BasicDBObject("name", Pattern.compile("^rj_.*$", Pattern.CASE_INSENSITIVE))).iterator();
        while (iterator5.hasNext()){
            System.out.println(iterator5.next().toJson());
        }


        System.out.println("-----------------------end-----------------------");
        mongoClient.close();
    }

    private static BasicDBObject eq(String key, Object value){
        return new BasicDBObject(key, value);
    }
    private static BasicDBObject gt(String key, Object value){
        return new BasicDBObject(key, new BasicDBObject("$gt", value));
    }
    private static BasicDBObject gte(String key, Object value){
        return new BasicDBObject(key, new BasicDBObject("$gte", value));
    }
    private static BasicDBObject lt(String key, Object value){
        return new BasicDBObject(key, new BasicDBObject("$lt", value));
    }
    private static BasicDBObject lte(String key, Object value){
        return new BasicDBObject(key, new BasicDBObject("$lte", value));
    }
    private static BasicDBObject ne(String key, Object value){
        return new BasicDBObject(key, new BasicDBObject("$ne", value));
    }
}
