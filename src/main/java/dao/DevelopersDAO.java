package dao;

import entity.Developers;

import java.sql.*;

public class DevelopersDAO extends ConnectionToDB implements DAO<Developers> {


    @Override
    public void create(Developers developers) {
        try (Connection c = getConnection()) {

            PreparedStatement ps = c.prepareStatement("INSERT INTO `developers` (`id`,`name`,`salary`,`projects_id`) VALUES (?,?,?,?);");
            ps.setString(1, String.valueOf(developers.getId()));
            ps.setString(2, developers.getName());
            ps.setString(3, String.valueOf(developers.getSalary()));
            ps.setString(4, String.valueOf(developers.getProject_id()));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Developers read(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM `developers` WHERE id=?;");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                int id_developers = rs.getInt("id");
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                int projects_id = rs.getInt("projects_id");



                Developers developers = new Developers(id_developers, name, salary, projects_id);

                return developers;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Developers developers) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("UPDATE `developers` set name=?, salary=?, projects_id=? WHERE id=?;");
            ps.setString(1, developers.getName());
            ps.setString(4, String.valueOf(developers.getId()));
            ps.setString(2, String.valueOf(developers.getSalary()));
            ps.setString(3, String.valueOf(developers.getId()));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {

        try (Connection c = getConnection()) {
            PreparedStatement ps=c.prepareStatement("DELETE FROM `developers` WHERE id=?;");
            ps.setString(1,String.valueOf(id));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
