package repositories;

import java.util.*;
import it.unifi.cerm.playmorphia.PlayMorphia;
import models.Employee;
import org.bson.types.ObjectId;

import javax.inject.Inject;


public class EmployeeRepository {

    private final PlayMorphia morphia;

    @Inject
    public EmployeeRepository(PlayMorphia morphia) {
        this.morphia = morphia;
    }


    public List<Employee> findAll() {
        List<Employee> employees = morphia.
                datastore().
                createQuery(Employee.class).
                asList();
        return employees;
    }

    public void save(Employee e) {
        morphia.datastore().save(e);
    }
}
