package repositories;

import java.util.*;
import org.bson.Document;
import org.bson.conversions.Bson;
//import models.Employee;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.DeleteResult;


// import com.mongodb.client.model.ValidationOptions;

public class EmployeeRepository {

        MongoClient mongo;
        MongoDatabase database;
        MongoCollection data;
        EmployeeRepository(){
                mongo = MongoClients.create();
                database = mongo.getDatabase("EmployeeDB");
                data = database.getCollection("employees");
                
            }

        public ArrayList<Document> findAll() {
            ArrayList<Document> list = (ArrayList)data.find().into(new ArrayList<>());
            return list;
        }

        public void save(String eid,String name,String email,long phone) {
            Document employee = new Document();
            employee.append("eid", eid);
            employee.append("name", name);
            employee.append("email", email);
            employee.append("phone", phone);
            data.insertOne(employee);
        }

        public Document findById(String eid){
            Document employee = new Document();
            employee = (Document) data.find(new Document("eid", eid)).first();
            return employee;
        }

        public void findAndUpdate(String eid,String name,String email,long phone){
            Bson filter = eq("eid", eid);
            Bson update1 = set("name", name);
            Bson update2 = set("email", email);
            Bson update3 = set("phone", phone);
            Bson updates = combine(update1, update2, update3);
            Document oldVersion = (Document) data.findOneAndUpdate(filter, updates);
        }
        public void delete(String id){
            Bson filter = eq("eid", id);
            DeleteResult result = data.deleteOne(filter);
        }
}
