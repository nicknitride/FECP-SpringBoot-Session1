package org.ZooFloresManaloPardines;


import org.ZooFloresManaloPardines.Building.PachydermEnclosure;
import org.ZooFloresManaloPardines.People.Handler;
import org.ZooFloresManaloPardines.People.Manager;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public static void zooHandler(Zoo zoo){
        ArrayList<Handler> handlerArray = zoo.getHandlerArrayList();
        ArrayList<String> acceptableStrings = new ArrayList<>();
        ArrayList<String> enteredStrings = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<handlerArray.size(); i++){
            if (handlerArray.get(i).getLocation().toString().equals("PachydermEnclosure") ||
            handlerArray.get(i).getLocation().toString().equals("FelineEnclosure") ||
                    handlerArray.get(i).getLocation().toString().equals("BirdEnclosure")
            ){
            acceptableStrings.add(handlerArray.get(i).getName());
            }
        }
        System.out.println("Handler list: "+acceptableStrings);
        System.out.println("You've accessed: "+enteredStrings);
        System.out.println("Please set itinerary for all handlers to exit this menu.");
        while(enteredStrings.size()!=acceptableStrings.size()){
            System.out.print("Enter your name (handler): ");
            String userInput = sc.nextLine();
            if(acceptableStrings.contains(userInput)){
                enteredStrings.add(userInput);
            }else{
                System.out.println("Error, handler does not exist.");
                System.out.println("Handler list: "+acceptableStrings);
                System.out.println("You've accessed: "+enteredStrings);
                System.out.println("Please set itinerary for all handlers to exit this menu.");
            }
        }



    }
    public static void zooStaffSetup(Scanner sc, Zoo zoo){
        String handlerName;
        System.out.println("=== Zoo Staff Setup Menu ===");
        System.out.printf("Welcome, Manager (%s)\n",zoo.getAdminObject().getName());
        System.out.print("Enter Pachyderm Enclosure Handler's name: ");
        handlerName = sc.nextLine();
        zoo.addHandlerToZoo(new Handler(handlerName,zoo.pachydermEnclosure));
        System.out.print("Enter Feline Enclosure Handler's name: ");
        handlerName = sc.nextLine();
        zoo.addHandlerToZoo(new Handler(handlerName,zoo.felineEnclosure));
        System.out.print("Enter Bird Enclosure Handler's name: ");
        handlerName = sc.nextLine();
        zoo.addHandlerToZoo(new Handler(handlerName,zoo.birdEnclosure));
        System.out.print("Enter Veterinarian's name: ");
        handlerName = sc.nextLine();
        zoo.addHandlerToZoo(new Handler(handlerName,zoo.hospitalBuilding));
        System.out.print("Enter Vendor for Ticket Shop's name: ");
        handlerName = sc.nextLine();
        zoo.addHandlerToZoo(new Handler(handlerName,zoo.ticketBooth));
        System.out.print("Enter Food Vendor's name: ");
        handlerName = sc.nextLine();
        zoo.addHandlerToZoo(new Handler(handlerName,zoo.restaurant));
        System.out.print("Enter Vendor for Gift Shop's name: ");
        handlerName = sc.nextLine();
        zoo.addHandlerToZoo(new Handler(handlerName,zoo.giftShop));
        System.out.println("=== ✅ Completed Zoo Staff Setup ===");
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

        boolean successfulSetup = false;
        if(validateCredentials(uname, pass)){
            System.out.println("Congratulations you are logged in.");
            while(!exitCondition){
                displayMenu();
                System.out.print("Enter an option (1-5): ");
                String uChoice = userInput.nextLine();
                switch(uChoice){
                    case "1":
                        zooStaffSetup(userInput,zoo);
                        successfulSetup = true;
                        break;
                    case "2":
                        if(successfulSetup){
                            zooHandler(zoo);
                        }else{
                            System.out.println("Please enter Zoo Setup before setting the Handlers.");
                        }
                        break;
                    case "3":
                        zoo.getAdminObject().openZoo();
                        break;
                    case "4":
                        zoo.getAdminObject().closeZoo();
                        break;
                    case "5":
                        if(successfulSetup){
                            System.out.println("Exiting");
                            exitCondition = true;
                        }
                        else{
                            System.out.println("Error❗️, Zoo Staff itinerary hasn't been set up.");
                        }
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
