package org.ZooFloresManaloPardines;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ZooMain {
    public static boolean validateTicket(Zoo zoo,Scanner sc){

        if (zoo.getUserTicket() == null){
            return false;
        }

        System.out.println("\nFor user security, please present your ticket number.");
        System.out.print("Enter your ticket number (e.g. ZOO-1234): ");
        String userChoice = sc.nextLine();

        return (zoo.getUserTicket().equals(userChoice));
    }


    public static void main(String[] args) {
        Zoo zoo = SharedZoo.zoo;
        Scanner userIn = new Scanner(System.in);
        String userChoice;
        boolean exitCondition = false;
        //Manager has to log in and open zoo.
        ZooAdmin.main(args);
        while(!exitCondition){
            boolean zooOpenStatus = zoo.getAdminObject().getZooOpenStatus();
            if(zooOpenStatus){
                if(!zoo.getVisitorLoggedIn()){
                    TicketingModule.main(args);
                    if(!validateTicket(zoo,userIn)){
                        System.out.println("Incorrect or lost ticket, please purchase another.");
                    }
                    else
                        zoo.setVisitorLoggedIn(true);
                }else{
                    System.out.println("Welcome Back, "+zoo.getUserInfoArray().get(2)+"!");
                    ZooModule zooStart = new ZooModule(zoo);
                    zooStart.startZooModule();
                }
            }else{
                System.out.println("Sorry, the zoo has closed. ❌");
                exitCondition = true;
            }
        }
    }
}
