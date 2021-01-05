package repositories;

import java.util.*;
import it.unifi.cerm.playmorphia.PlayMorphia;
import models.Employee;

import javax.inject.Inject;


public class EmployeeRepository {

    private final PlayMorphia morphia;

    @Inject
    public EmployeeRepository(PlayMorphia morphia) {
        this.morphia = morphia;
    }


    public List<Employee> findAll() {
        
        return morphia.
        datastore().
        createQuery(Employee.class).
        asList();
    }


    public void save(Employee e) {
        morphia.datastore().save(e);
    }


    public Employee findById(String id) {
        
        return morphia.
        datastore().
        createQuery(Employee.class).
        field("eid").
        equal(id).
        get();

    }

    public void findAndUpdate(String id) {
        return;
    }

}
