package com.vti.Utils;

import java.util.Scanner;

public class Scannerutils {
    static Scanner sc = new Scanner(System.in);
    //Handle exception to string input
    public static String inputString(String errorMessage) {
        while (true) {
            String inputString = sc.nextLine();
            inputString = inputString.trim();
            inputString = inputString.replaceAll("\\s+", " ");
            return inputString;
        }
    }
    //Handle exception to email input
    public static String inputEmail(String errorMessage) {
        while (true) {
            String email = Scannerutils.inputString(errorMessage);
            if (!email.contains("@gmail.com")) {
                System.err.println(errorMessage);
            } else {
                return email;
            }
        }
    }
    //Handle exception to password input
    public static String inputPassword(String errorMessage) {
        while (true) {
            String password = Scannerutils.inputString(errorMessage);
            if (password.length() < 6 || password.length() > 12) {
                System.err.println(errorMessage);
                continue;
            }
            boolean hasAtLeast1Character = false;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    hasAtLeast1Character = true;
                    break;
                }
            }
            if (hasAtLeast1Character) {
                return password;
            } else {
                System.err.println(errorMessage);
                System.out.print("Your password is not valid, please try again");
            }
        }
    }
}
