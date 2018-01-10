package com.location.tracker.repository;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;


import com.mongodb.MongoClient;

public class MongoDbUtils {

    private static final Log log = LogFactory.getLog(MongoDbUtils.class);

      public MongoOperations getDbConnection(String dbName){
        MongoOperations mongoOps = new MongoTemplate(new MongoClient(),dbName);

        return mongoOps;
    }
}
