package org.ZooFloresManaloPardines;

import java.util.Scanner;

public class ZooMain {
    public static void main(String[] args) {
        Zoo zoo = SharedZoo.zoo;
        Scanner userIn = new Scanner(System.in);
        boolean exitCondition = false;
        //Manager has to log in and open zoo.
        ZooAdmin.main(args);

        while(!exitCondition){
            System.out.println("Are you a visitor? (y/n): ");
            String userChoice = userIn.nextLine();
            if(userChoice.toLowerCase().equals("y") && zoo.getAdminObject().getZooOpenStatus()){
                if(!zoo.getVisitorLoggedIn()){
                    TicketingModule.main(args);
                }else{
                    System.out.println("Welcome Back, "+zoo.getUserInfoArray().get(2)+"!");
                }
            } else if (userChoice.toLowerCase().equals("n") && zoo.getAdminObject().getZooOpenStatus()) {
                // Add staff menus here
            }else if(!zoo.getAdminObject().getZooOpenStatus()){
                System.out.println("Sorry, zoo is still closed.");
            }
            System.out.println("Enter any key to continue or (q) to quit.");
            System.out.print("Enter an option (zoo to enter zoo or q): ");
            userChoice = userIn.nextLine();
            if(userChoice.toLowerCase().equals("q")){
                exitCondition=true;
            } else if(userChoice.toLowerCase().equals("zoo")){
                ZooModule zooStart = new ZooModule(zoo);
                zooStart.startZooModule();
            }
        }


//        //Just for testing
//        while(!exitCondition){
//            System.out.print("Enter an option: ");
//            String choice = userIn.nextLine();
//            switch (choice){
//                case "1":
//                    System.out.println("Shared Zoo Logged In: "+zoo.getUserTicket());
//                    break;
//                default:
//                    exitCondition = true;
//            }
//        }
    }
}
