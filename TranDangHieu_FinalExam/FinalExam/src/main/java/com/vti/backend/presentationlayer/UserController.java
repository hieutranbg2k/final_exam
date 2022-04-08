package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.Manager;
import com.vti.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    IUserService IUserService;

    public UserController() throws SQLException {
        IUserService = new UserService();
    }

    public List<User> getUserList() throws SQLException {
        return IUserService.getUserList();
    }

    public List<User> getUserListFromId(int id) throws SQLException {
        return IUserService.getUserListFromId(id);
    }

    public List<Manager> managerList() throws SQLException {
        return IUserService.managerList();
    }

    public User login(String email, String password) throws SQLException {
        return IUserService.login(email, password);
    }
}
