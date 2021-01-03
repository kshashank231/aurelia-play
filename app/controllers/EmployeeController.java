package controllers;

import java.util.*;
import models.Employee;
import repositories.EmployeeRepository;
import play.mvc.*;
import javax.inject.Inject;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

public class EmployeeController extends Controller {


    @Inject
    private EmployeeRepository employee;

    public Result index() {
        List<Employee>  e = employee.findAll();
        
        return ok(Json.toJson(e));
        
    }
  
    public Result create(Http.Request request) {
        JsonNode json = request.body().asJson();
        Employee newEmp = Json.fromJson(json, Employee.class);
        employee.save(newEmp);
        return ok(Json.toJson("Done!"));
    }
}
