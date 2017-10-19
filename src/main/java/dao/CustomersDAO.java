package dao;

import entity.Customers;

import java.sql.*;


public class CustomersDAO extends ConnectionToDB implements DAO<Customers> {


    @Override
    public void create(Customers customers) {
        try (Connection c = getConnection()) {

            PreparedStatement ps = c.prepareStatement("INSERT INTO `customers` (`id`,`name`) VALUES (?,?);");
            ps.setString(1, String.valueOf(customers.getId()));
            ps.setString(2, customers.getName());
            ps.execute();

        } catch (SQLException e) {

        }
    }

    @Override
    public Customers read(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM `customers` WHERE id=?;");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                int id_customers = rs.getInt("id");
                String name = rs.getString("name");

                Customers customers = new Customers(id_customers, name);

                return customers;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Customers customers) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("UPDATE `customers` set name=? WHERE id=?;");
            ps.setString(1, customers.getName());
            ps.setString(2, String.valueOf(customers.getId()));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("DELETE FROM `customers` WHERE id=?;");
            ps.setString(1, String.valueOf(id));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
