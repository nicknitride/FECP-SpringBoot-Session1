package org.ZooFloresManaloPardines;

import java.util.Scanner;

public class ZooMain {
    public static void main(String[] args) {
        Zoo zoo = SharedZoo.zoo;
        Scanner userIn = new Scanner(System.in);
        boolean exitCondition = false;
        //Manager has to log in and open zoo.
        ZooAdmin.main(args);

        System.out.println("Are you a visitor? (y/n): ");
        String userChoice = userIn.nextLine();
        if(userChoice.toLowerCase().equals("y") && zoo.getAdminObject().getZooOpenStatus()){
            TicketingModule.main(args);
        } else if (userChoice.toLowerCase().equals("n") && zoo.getAdminObject().getZooOpenStatus()) {
            // Add staff menus here
        }else if(!zoo.getAdminObject().getZooOpenStatus()){
            System.out.println("Sorry, zoo is still closed.");
        }
        while(!exitCondition){
            System.out.print("Enter an option: ");
            String choice = userIn.nextLine();
            switch (choice){
                case "1":
                    System.out.println("Shared Zoo Logged In: "+zoo.getUserTicket());
                    break;
                default:
                    exitCondition = true;
            }
        }
    }
}
