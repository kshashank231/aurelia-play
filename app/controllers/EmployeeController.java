package controllers;

import java.util.*;
import repositories.EmployeeRepository;
import play.mvc.*;
import javax.inject.Inject;
import org.bson.Document;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

//import models.Employee;


public class EmployeeController extends Controller {

    @Inject
    private EmployeeRepository employee;

    public Result getEmployees() {
        ArrayList<Document> list = employee.findAll();
        return ok(Json.toJson(list));
    }
  
    public Result createEmployee(Http.Request request) {
         JsonNode newEmp = request.body().asJson();
         String eid = newEmp.get("eid").asText();
         String name = newEmp.get("name").asText();
         String email = newEmp.get("email").asText();
         long phone = newEmp.get("phone").asLong();
         employee.save(eid, name, email, phone);
         return ok(Json.toJson("Done!"));
    }

    public Result getEmployee(String id) {
        Document  e = employee.findById(id);
        return ok(e.toJson());
    }
    public Result updateEmployee(String id, Http.Request request) {
        JsonNode emp = request.body().asJson();
        String name = emp.get("name").asText();
        String email = emp.get("email").asText();
        long phone = emp.get("phone").asLong();
        employee.findAndUpdate(id, name, email, phone);
        Map<String, Object> res = new HashMap<>();
        res.put("Status", 200);
        return ok(Json.toJson(res));
    }
    public Result deleteEmployee(String id){
        employee.delete(id);
        return ok(Json.toJson("Deleted!"));
    }

}
