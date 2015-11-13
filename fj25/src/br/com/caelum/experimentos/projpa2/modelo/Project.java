package br.com.caelum.experimentos.projpa2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by fabio on 13/11/15.
 */
@Entity(name = "PROJPA2_PROJECT")
public class Project {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany(mappedBy="projects")
    private Collection<Employee> employees = new ArrayList<Employee>();

    public Project(String name) {
        this.name = name;
    }

    public void addEmployees(Employee employee) {
        this.employees.add(employee);
//        employee.getProjects().add(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
