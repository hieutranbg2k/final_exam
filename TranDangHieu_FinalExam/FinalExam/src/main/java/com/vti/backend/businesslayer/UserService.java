package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.Manager;
import com.vti.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    IUserRepository iUserRepository;

    public UserService() throws SQLException {
        iUserRepository = new UserRepository();
    }

    public List<User> getUserList() throws SQLException {
        return iUserRepository.getUserList();
    }

    public List<User> getUserListFromId(int id) throws SQLException {
        return iUserRepository.getUserListFromId(id);
    }

    public List<Manager> managerList() throws SQLException {
        return iUserRepository.managerList();
    }

    public User login(String email, String password) throws SQLException {
        return iUserRepository.login(email, password);
    }
}
