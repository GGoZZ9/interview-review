package cn.oldensheepdog.java.test;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class TestMongo {

//    public static void main(String[] args) {
//        String resultArray = mongoService.findFieldOfAll("mac", jsonObject.get("ap_mac").toString(), "t_ap", String.class);
//        jsonObject.get("ap_mac").toString() = 98:6D:35:70:78:AB
//    }
//
//    public <T> List<T> findFieldOfAll(String field, Object value, String collection, Class<T> entityClass) {
//        Query query = (value == "" || value == null) ?
//                new Query(Criteria.where(field).ne(null)) :
//                new Query(Criteria.where(field).is(value));
//        return this.mongoTemplate.find(query, entityClass, collection);
//    }
}
