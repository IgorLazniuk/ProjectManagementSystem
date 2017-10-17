package dao;

import entity.Projects;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IGOR.LAZNIUK on 13.10.2017.
 */
public class ProjectsDAO extends ConnectionToDB implements DAO<Projects> {
    @Override
    public void create(Projects projects) {
        try (Connection c = getConnection()) {

            PreparedStatement ps = c.prepareStatement("INSERT INTO `projects` (`id`,`name`,`cost`,`companies_id`,`customers_id`) VALUES (?,?,?,?,?);");
            ps.setString(1, String.valueOf(projects.getId()));
            ps.setString(2, projects.getName());
            ps.setString(3, String.valueOf(projects.getCost()));
            ps.setString(4, String.valueOf(projects.getCompanies_id()));
            ps.setString(5, String.valueOf(projects.getCustomers_id()));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Projects read(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM `projects` WHERE id=?;");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                int id_projects = rs.getInt("id");
                String name = rs.getString("name");
                int cost = rs.getInt("cost");
                int companies_id = rs.getInt("companies_id");
                int customers_id = rs.getInt("customers_id");


                Projects projects = new Projects(id_projects, name, cost, companies_id, customers_id);

                return projects;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Projects projects) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("UPDATE `projects` set name=?, cost=?, companies_id=?, customers_id WHERE id=?;");
            ps.setString(1, projects.getName());
            ps.setString(2, String.valueOf(projects.getCost()));
            ps.setString(3, String.valueOf(projects.getCompanies_id()));
            ps.setString(4, String.valueOf(projects.getCustomers_id()));
            ps.setString(5, String.valueOf(projects.getId()));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("DELETE FROM `projects` WHERE id=?;");
            ps.setString(1, String.valueOf(id));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
