package com.vti.frontend;

import com.vti.Utils.Scannerutils;
import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Manager;
import com.vti.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Function {
    static Scanner sc;
    private UserController userController;

    public Function() throws SQLException {
        sc = new Scanner(System.in);
        userController = new UserController();
    }

    //Function to get list of users from a project with id input
    public void getUsersFromProjectId() throws SQLException {
        System.out.println("Enter project id: ");
        int input = sc.nextInt();
        List<User> users = userController.getUserListFromId(input);
        System.out.printf("%-10s %-20s %-20s %-30s %-20s \n", "ID", "Fullname", "Role", "Email", "Password");
        for (User user : users
        ) {
            System.out.println(user.toString());
        }
    }
    //Function to list all the manager
    public void managerList() throws SQLException {
        List<Manager> managers = userController.managerList();
        System.out.printf("%-10s %-20s %-30s %-20s %-20s \n", "ID", "Fullname", "Email", "Password", "ExpInYear");
        for (Manager manager : managers
        ) {
            System.out.println(manager.toString());
        }
    }

    //Function to allow the users to login
    public void login() throws SQLException {
        while (true) {
            System.out.println("Enter account email: ");
            String email = Scannerutils.inputEmail("Invalid email format, please try again ");
            System.out.println("Enter account password: ");
            String password = Scannerutils.inputPassword("Wrong password, please try again ");
            User user = userController.login(email, password);
            System.out.println("User's information: ");
            System.out.printf("%-10s %-20s %-20s %-30s %-20s \n", "ID", "Fullname", "Role", "Email", "Password");
            System.out.println(user.toString());
            return;
        }
    }
    //The interface of menu
    public void menuInterface() {
        System.out.println("==============================");
        System.out.println("====== MENU ==============");
        System.out.println("1.Users list of project");
        System.out.println("2.Manager list");
        System.out.println("3.Login");
        System.out.println();
        System.out.println("0.Exit");
        System.out.println("Your option: ");
    }

    //Specific functions of menu
    public void menu() throws SQLException {
        while (true) {
            menuInterface();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    getUsersFromProjectId();
                    break;
                case 2:
                    managerList();
                    break;
                case 3:
                    login();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

}
