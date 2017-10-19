package entity;

public class Projects {

    private Integer id;
    private String name;
    private Integer cost;
    private Integer companies_id;
    private Integer customers_id;

    public Projects(Integer id, String name, Integer cost, Integer companies_id, Integer customers_id) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.companies_id = companies_id;
        this.customers_id = customers_id;
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCompanies_id() {
        return companies_id;
    }

    public void setCompanies_id(Integer companies_id) {
        this.companies_id = companies_id;
    }

    public Integer getCustomers_id() {
        return customers_id;
    }

    public void setCustomers_id(Integer customers_id) {
        this.customers_id = customers_id;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", companies_id=" + companies_id +
                ", customers_id=" + customers_id +
                '}';
    }
}
