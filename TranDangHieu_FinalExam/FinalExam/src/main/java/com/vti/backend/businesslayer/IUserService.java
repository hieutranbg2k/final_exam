package com.vti.backend.businesslayer;

import com.vti.entity.Manager;
import com.vti.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public List<User> getUserList() throws SQLException;

    public List<User> getUserListFromId(int id) throws SQLException;

    public List<Manager> managerList() throws SQLException;

    public User login(String email, String password) throws SQLException;
}
