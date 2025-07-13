package org.ZooFloresManaloPardines;

import java.util.ArrayList;
import java.util.Scanner;

public class TicketingModule {
    public static String generateTicket(){
        String randNum = Integer.toString((int)(Math.random()*12000));
        return String.format("ZOO-%s",randNum);
    }
    public static ArrayList<String> discountLogic(String name, int age){
        ArrayList<String> outputArray = new ArrayList<>();
        if((age>=0) && (age<=5)){
            outputArray.add(0,"Child");
            outputArray.add(1,"$0.00");
        } else if ((age>=6) && (age<=17)) {
            outputArray.add(0,"Student");
            outputArray.add(1,"$75.00");
        }else if ((age>=18) && (age<=59)) {
            outputArray.add(0,"Adult");
            outputArray.add(1,"$150.00");
        }else if ((age>59) && (age<150)) {
            outputArray.add(0,"Senior");
            outputArray.add(1,"$50.00");
        }else{
            System.out.println("Invalid age.");
            outputArray.add(0,"Default ticket");
            outputArray.add(1,"$150.00");
        }
        outputArray.add(2,name);
        return outputArray;
    }
    public static String printMenu(){
        String outputString = "=== Zoo Ticket Menu 🎟️===";
        outputString+="\n===Available Experiences=== " +
                "\n🐂 Visit animal enclosures" +
                "\n🍿 Buy snacks and drinks " +
                "\n🏥 Listen to science lectures" +
                "\n🎁 Buy gifts at the gift shop" +
                "\nWould you like to buy a 🎟️? (y/n): ";
        return outputString;
    }
    public static void main(String[] args) {
        Zoo zoo = SharedZoo.zoo;
        Scanner userInput = new Scanner(System.in);
        String userName,ticketNumber;
        int userAge;
        String userResponse;
        ArrayList<String> ticketOutput;
        System.out.print(printMenu());
        userResponse = userInput.nextLine().toLowerCase();
        switch(userResponse){
            case "y","yes":
                System.out.print("Enter your name: ");
                userName =  userInput.nextLine();
                System.out.print("Enter your age: ");
                userAge = userInput.nextInt();
                userInput.nextLine();
                ticketOutput = discountLogic(userName,userAge);
                System.out.printf("You qualify for a '%s' ticket, price: %s\n",ticketOutput.get(0),ticketOutput.get(1));
                System.out.print("Would you like to purchase the ticket? (y/n): ");
                String purchaseDecision = userInput.nextLine().toLowerCase();
                if(purchaseDecision.equals("y")){
                    System.out.print("Generating ticket...");
                    ticketNumber = generateTicket();
                    System.out.print("Generated ticket: ");
                    System.out.println(ticketNumber);
                    System.out.printf("Enjoy your visit, %s!\n",ticketOutput.get(2));
                    zoo.setUserTicketNumber(ticketNumber);
                    zoo.setUserInfoArray(ticketOutput);
                }else{
                    System.out.println("Exiting.");
                }
                break;
            case "n","no":
                System.out.println("Exiting ticketing system.");
                break;
        }
    }
}
