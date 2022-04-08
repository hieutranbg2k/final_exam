package com.vti.backend.datalayer;

import com.vti.Utils.JDBCutils;
import com.vti.entity.Manager;
import com.vti.entity.Role;
import com.vti.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    Connection connection;
    List<User> list;

    public UserRepository() throws SQLException {
        //create connection
        this.connection = JDBCutils.getConnection();
        list = new ArrayList<>();
    }

    public List<User> getUserList() throws SQLException {
        try {
            //create statement object
            Statement statement = connection.createStatement();

            //execute query and get the results
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `user`");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String password = resultSet.getString(4);
                Role role = Role.valueOf(resultSet.getString(5));
                User user = new User(id, name, email, password, role);
                list.add(user);
            }
            return list;
        } finally {
            connection.close();
        }
    }

    public List<User> getUserListFromId(int id) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        //create statement object
        Statement statement = connection.createStatement();
        String sql = "SELECT \tu.id, u.`fullName`, u.`email`,u.`password`,pau.`Role` \n" +
                "FROM\t`ProjectAndUser` pau\n" +
                "JOIN\t`User` u\tON u.id = pau.userId\n" +
                "WHERE\tpau.projectId = ?";
        //execute the query
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        //handle the result
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int userID = resultSet.getInt(1);
            String userName = resultSet.getString(2);
            String email = resultSet.getString(3);
            String password = resultSet.getString(4);
            Role role = Role.valueOf(resultSet.getString(5));
            User user = new User(userID, userName, email, password, role);
            users.add(user);
        }
        return users;
    }

    public List<Manager> managerList() throws SQLException {
        List<Manager> managers = new ArrayList<>();
        //create statement object
        Statement statement = connection.createStatement();
        //execute query
        String sql = "SELECT u.id, u.`fullName`, u.`email`,u.`password`,pau.`Role`,m.`expInYear`\n" +
                "FROM\t`ProjectAndUser` pau\n" +
                "JOIN\t`User` u\tON u.id = pau.userId\n" +
                "JOIN\tManager m \tON u.id = m.id\n" +
                "WHERE\t`Role` = 'MANAGER'";
        statement.executeQuery(sql);
        //handle the results
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            String password = resultSet.getString(4);
            Role role = Role.valueOf(resultSet.getString(5));
            int exp = resultSet.getInt(6);
            Manager manager = new Manager(id, name, email, password, role, exp);
            managers.add(manager);
        }
        return managers;
    }

    public User login(String email, String password) throws SQLException {
        User user = null;
        //execute query
        String sql = "SELECT \tu.id, u.`fullName`, u.`email`,u.`password`,pau.`Role`\t\n" +
                "FROM\t`User` u\n" +
                "JOIN \t`ProjectAndUser` pau ON u.id = pau.userId\n" +
                "WHERE\tu.`email` = ? AND `password` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        //handle the results
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int userID = resultSet.getInt(1);
            String userName = resultSet.getString(2);
            String Email = resultSet.getString(3);
            String Password = resultSet.getString(4);
            Role role = Role.valueOf(resultSet.getString(5));
            user = new User(userID, userName, Email, Password, role);
        }
        return user;
    }

}
