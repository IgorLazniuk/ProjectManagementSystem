package dao;

import entity.Projects;
import entity.Skills;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IGOR.LAZNIUK on 14.10.2017.
 */
public class SkillsDAO extends ConnectionToDB implements DAO<Skills> {
    @Override
    public void create(Skills skills) {
        try (Connection c = getConnection()) {

            PreparedStatement ps = c.prepareStatement("INSERT INTO `skills` (`id`,`name`,`developers_id`) VALUES (?,?,?);");
            ps.setString(1, String.valueOf(skills.getId()));
            ps.setString(2, skills.getName());
            ps.setString(3, String.valueOf(skills.getDevelopers_id()));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Skills read(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM `skills` WHERE id=?;");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                int id_skills = rs.getInt("id");
                String name = rs.getString("name");
                int developers_id = rs.getInt("developers_id");


                Skills skills = new Skills(id_skills, name, developers_id);

                return skills;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Skills skills) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("UPDATE `skills` set name=?, developers_id=? WHERE id=?;");
            ps.setString(1, skills.getName());
            ps.setString(2, String.valueOf(skills.getDevelopers_id()));
            ps.setString(3, String.valueOf(skills.getId()));

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps=c.prepareStatement("DELETE FROM `skills` WHERE id=?;");
            ps.setString(1,String.valueOf(id));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
