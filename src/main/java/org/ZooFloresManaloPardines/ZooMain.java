package org.ZooFloresManaloPardines;

import java.util.Scanner;

public class ZooMain {
    public static void main(String[] args) {
        Zoo zoo = SharedZoo.zoo;
        boolean exitCondition = false;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Are you a visitor? (y/n): ");
        TicketingModule.main(args);
        while(!exitCondition){
            System.out.print("Enter an option: ");
            String choice = userInput.nextLine();
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
