package org.ZooFloresManaloPardines;

import java.util.Scanner;

public class ZooMain {
    public static void main(String[] args) {
        Zoo zoo = SharedZoo.zoo;
        Scanner userIn = new Scanner(System.in);
        boolean exitCondition = false;

        System.out.println("Are you a visitor? (y/n): ");
        String userChoice = userIn.nextLine();
        if(userChoice.toLowerCase().equals("y")){
            TicketingModule.main(args);
        } else if (userChoice.toLowerCase().equals("n")) {
            ZooAdmin.main(args);
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
