package ru.job4j.jdbc;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection connection;
    private static final String TABLE = "items";

    TrackerSQL() {
        init();
    }

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    @Override
    public Item add(Item item) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + TABLE + " (name, description) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, item.getName());
            statement.setString(2, item.getDesc());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE " + TABLE + " SET name = ?, description = ? where id = ?")) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.setInt(3, Integer.parseInt(item.getId()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void delete(String id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM " + TABLE + " WHERE ID = ?")) {
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"), rs.getString("description"));
                result.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE + " WHERE name = ?")) {
        ps.setString(1, key);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Item item = new Item(rs.getString("name"), rs.getString("description"));
            result.add(item);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = null;
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE + " WHERE id = ?")) {
            ps.setInt(1, Integer.valueOf(id));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    result = new Item(rs.getString("name"), rs.getString("description"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private boolean createTable() {
        boolean result = false;
        try (PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS " + TABLE + " (id SERIAL PRIMARY KEY, name varchar(225), description varchar(225))")) {
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {

    }

}
