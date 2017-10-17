package entity;

/**
 * Created by IGOR.LAZNIUK on 29.09.2017.
 */
public class Developers {
    private Integer id;
    private String name;
    private Integer salary;
    private Integer projects_id;

    public Developers(Integer id, String name, Integer salary, Integer projects_id) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.projects_id = projects_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getProject_id() {
        return projects_id;
    }

    public void setProject_id(Integer project_id) {
        this.projects_id = project_id;
    }

    @Override
    public String toString() {
        return "Developers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", project_id=" + projects_id +
                '}';
    }
}
