package org.ZooFloresManaloPardines;


import org.ZooFloresManaloPardines.People.Manager;

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

    public static void displayMenu(){
        System.out.println("=== 🦁Zoo Admin Main Menu ===");
        System.out.println("1. Setup Zoo Staff");
        System.out.println("2. Access Handler Module");
        System.out.println("3. Open Zoo to Visitors");
        System.out.println("4. Close Zoo to Visitors");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {
        boolean exitCondition = false;
        Zoo zoo = SharedZoo.zoo;
        Scanner userInput = new Scanner(System.in);
        System.out.println("=== Welcome to the (🐘) Admin Panel!===");
        System.out.println("Please log in.");
        System.out.print("Please enter your username: ");
        String uname = userInput.nextLine();
        System.out.print("Enter your password: ");
        String pass = userInput.nextLine();
        if(validateCredentials(uname, pass)){
            System.out.println("Congratulations you are logged in.");
            while(!exitCondition){
                displayMenu();
                System.out.print("Enter an option (1-5): ");
                String uChoice = userInput.nextLine();
                switch(uChoice){
                    case "1":
                        System.out.println("Add Zoo Staff Menu Here");
                        break;
                    case "2":
                        System.out.println("Add Handler Module here");
                        break;
                    case "3":
                        zoo.getAdminObject().openZoo();
                        break;
                    case "4":
                        zoo.getAdminObject().closeZoo();
                        break;
                    case "5":
                        System.out.println("Exiting");
                        exitCondition = true;
                        break;
                    default:
                        System.out.println("Exiting. Invalid input.");
                        exitCondition = true;
            }
            }
        }else{
            System.out.println("Incorrect details entered.");
        }
    }
}
