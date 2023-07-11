package com.pandorapharmacymanager.databaseimplementation;

import com.pandorapharmacymanager.database.UserDAO;
import com.pandorapharmacymanager.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImplementation implements UserDAO {
    @Override
    public User get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(User user) throws SQLException {
        return 0;
    }

    @Override
    public int insert(User user) throws SQLException {
        return 0;
    }

    @Override
    public int update(User user) throws SQLException {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }
}
