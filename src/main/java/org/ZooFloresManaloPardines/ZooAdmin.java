package org.ZooFloresManaloPardines;


import java.util.Scanner;

public class ZooAdmin {
    private static String password;
    private static String userName;

    public static Boolean validateCredentials(String uname, String pass){
        return uname.equals(userName) && pass.equals(password);
    }

    public static void setUserName(String userName) {
        ZooAdmin.userName = userName;
    }

    public static void setPassword(String password) {
        ZooAdmin.password = password;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("=== Welcome to the (🐘) Admin Panel!===");
        System.out.println("Please log in.");
        System.out.print("Please enter your username: ");
        String uname = userInput.nextLine();
        System.out.print("Enter your password: ");
        String pass = userInput.nextLine();
        if(validateCredentials(uname, pass)){
            System.out.println("Congratulations you are logged in.");
        }else{
            System.out.println("Incorrect details entered.");
        }
    }
}
