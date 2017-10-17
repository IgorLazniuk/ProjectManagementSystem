package entity;

/**
 * Created by IGOR.LAZNIUK on 14.10.2017.
 */
public class Customers {

    private Integer id;
    private String name;

    public Customers(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Сustomers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    ;
}
