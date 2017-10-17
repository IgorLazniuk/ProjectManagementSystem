package entity;

/**
 * Created by IGOR.LAZNIUK on 29.09.2017.
 */
public class Skills {
    private Integer id;
    private String name;
    private Integer developers_id;

    public Skills(Integer id, String name, Integer developers_id) {
        this.id = id;
        this.name = name;
        this.developers_id = developers_id;
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

    public Integer getDevelopers_id() {
        return developers_id;
    }

    public void setDevelopers_id(Integer developers_id) {
        this.developers_id = developers_id;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developers_id=" + developers_id +
                '}';
    }
}
