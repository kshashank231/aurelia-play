package controllers.mongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.typesafe.config.Config;
import it.unifi.cerm.playmorphia.MongoClientFactory;

import java.util.Arrays;

public class MyMongoClientFactory  extends MongoClientFactory {

    private Config config;

    public MyMongoClientFactory(Config config) {
        super(config);
        this.config = config;
    }

    public MongoClient createClient() throws Exception {
         return new MongoClient(Arrays.asList(
                 new ServerAddress("localhost", 27017)
                 )
         );
     }

    public String getDBName() {
        return config.getString("playmorphia.database");
    }

}