package repositories.user;

import db.DB;
import models.User;
import repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final DB db;

    public UserRepository(DB db) {
        this.db = db;
    }

    @Override
    public User get(int id) {
        User user = null;
        Connection conn = db.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = " + id);
            if (rs.next()) {
                user = new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        Connection conn = db.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public boolean create(User user) {
        Connection conn = db.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(name, surname) VALUES(?, ?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = db.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM users WHERE id = " + id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
