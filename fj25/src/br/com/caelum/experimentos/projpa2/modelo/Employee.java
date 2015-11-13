package br.com.caelum.experimentos.projpa2.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by fabio on 13/11/15.
 */
@Entity(name = "PROJPA2_EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToMany
    @JoinTable(name="PROJPA2_EMPLOYEE_PROJECT",
            joinColumns=@JoinColumn(name="EMP_ID"),
            inverseJoinColumns=@JoinColumn(name="PROJ_ID"))
    private Collection<Project> projects = new ArrayList<Project>();

    public Employee(String name) {
        this.name = name;
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

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }
}
