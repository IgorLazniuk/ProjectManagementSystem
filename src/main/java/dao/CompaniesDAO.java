package dao;
import entity.Companies;
import java.sql.*;


public class CompaniesDAO extends ConnectionToDB implements DAO<Companies> {

    public void create(Companies companies) {
        try (Connection c = getConnection()) {

            PreparedStatement ps = c.prepareStatement("INSERT INTO `companies` (`id`,`name`) VALUES (?,?);");
            ps.setString(1, String.valueOf(companies.getId()));
            ps.setString(2, companies.getName());
            ps.execute();

        } catch (SQLException e) {

        }

    }

    public Companies read(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM `companies` WHERE id=?;");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                int id_companies = rs.getInt("id");
                String name = rs.getString("name");

                Companies companies = new Companies(id_companies, name);

                return companies;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void update(Companies companies) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("UPDATE `companies` set name=? WHERE id=?;");
            ps.setString(1, companies.getName());
            ps.setString(2, String.valueOf(companies.getId()));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps=c.prepareStatement("DELETE FROM `companies` WHERE id=?;");
            ps.setString(1,String.valueOf(id));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
