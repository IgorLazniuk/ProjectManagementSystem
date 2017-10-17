package dao;

import entity.Customers;
import entity.Customers;

import java.sql.*;


/**
 * Created by IGOR.LAZNIUK on 14.10.2017.
 */
public class CustomersDAO extends ConnectionToDB implements DAO<Customers> {


    @Override
    public void create(Customers сustomers) {
        try (Connection c = getConnection()) {

            PreparedStatement ps = c.prepareStatement("INSERT INTO `сustomers` (`id`,`name`) VALUES (?,?);");
            ps.setString(1, String.valueOf(сustomers.getId()));
            ps.setString(2, сustomers.getName());
            ps.execute();

        } catch (SQLException e) {

        }
    }

    @Override
    public Customers read(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM `сustomers` WHERE id=?;");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                int id_сustomers = rs.getInt("id");
                String name = rs.getString("name");

                Customers customers = new Customers(id_сustomers, name);

                return customers;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Customers сustomers) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("UPDATE `сustomers` set name=? WHERE id=?;");
            ps.setString(1, сustomers.getName());
            ps.setString(2, String.valueOf(сustomers.getId()));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("DELETE FROM `сustomers` WHERE id=?;");
            ps.setString(1, String.valueOf(id));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
