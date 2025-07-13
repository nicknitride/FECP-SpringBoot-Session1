package org.ZooFloresManaloPardines;

import org.ZooFloresManaloPardines.Animal.*;
import org.ZooFloresManaloPardines.Building.*;
import org.ZooFloresManaloPardines.People.Handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class ZooModule {
    private Scanner sc;
    private Zoo zooData;

    private List<Shop> shopProducts;

    //representative animals for direct interaction in visitEnclosure()?
    private Animal representativeFeline;
    private Animal representativePachyderm;
    private Animal representativeBird;

    public ZooModule(Zoo zooData) {
        this.sc = new Scanner(System.in);
        this.zooData = zooData;

        //init representative animals from the zooData object
        if(zooData.pachydermEnclosure != null && !zooData.pachydermEnclosure.getAnimals().isEmpty()){
            this.representativePachyderm = zooData.pachydermEnclosure.getAnimals().getFirst();
        }

        if(zooData.felineEnclosure != null && !zooData.felineEnclosure.getAnimals().isEmpty()){
            this.representativeFeline = zooData.felineEnclosure.getAnimals().getFirst();
        }

        if(zooData.birdEnclosure != null && !zooData.birdEnclosure.getAnimals().isEmpty()){
            this.representativeBird = zooData.birdEnclosure.getAnimals().getFirst();
        }
    }

    public void startZooModule(){
        Zoo zoo = SharedZoo.zoo;
        System.out.println("Welcome to the Zoo!");
        boolean inZoo = true;
        while (inZoo) {
            displayZooMainMenu();
            int choice = getUserChoice();

            switch(choice){
                case 1:
                    visitEnclosure();
                    break;
                case 2:
                    visitShop();
                    break;
                case 3:
                    visitVet();
                    break;
                case 4:
                    System.out.println("Thank you for visiting!");
                    inZoo = false;
                    zoo.getAdminObject().closeZoo();
                    break;
                default:
                    System.out.println("Invalid choice. Enter a number from 1-4");
            }
        }
        sc.close();
    }

    private void displayZooMainMenu(){
        System.out.println("1. Visit Enclosure");
        System.out.println("2. Visit Shop");
        System.out.println("3. Visit Hospital");
        System.out.println("4. Leave Zoo");
        System.out.print("Choose an option: ");
    }

    private int getUserChoice(){
        while(!sc.hasNextInt()){
            System.out.println("Invalid input. Enter a number.");
            sc.next();
            System.out.print("Choose an option: ");
        }
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private void visitEnclosure() {
        System.out.println("===Zoo Enclosure===");
        System.out.println("Choose Enclosure:");
        System.out.println("1. " + zooData.pachydermEnclosure.name);
        System.out.println("2. " + zooData.felineEnclosure.name);
        System.out.println("3. " + zooData.birdEnclosure.name);
        System.out.print("Choose an option: ");

        int choice = getUserChoice();
        Enclosure selectedEnclosure = null;

        if(choice == 1){
            selectedEnclosure = zooData.pachydermEnclosure;
        }else if(choice == 2){
            selectedEnclosure = zooData.felineEnclosure;
        }else if(choice == 3){
            selectedEnclosure = zooData.birdEnclosure;
        } else{
            System.out.println("Invalid input. Select from 1-3.");
            System.out.println("What would you like to do next?");
            System.out.print("Choose an option: ");
            return;
        }

        Animal animalToInteract = null;
        if (selectedEnclosure != null && !selectedEnclosure.getAnimals().isEmpty()) {
            // Find the first healthy animal in the selected enclosure
            Optional<Animal> availableAnimal = selectedEnclosure.getAnimals().stream().filter(Animal::isHealthy).findFirst();
                    //.filter(Animal::isHealthy) // Filter for healthy animals
            if (availableAnimal.isPresent()) {
                animalToInteract = availableAnimal.get();
            }
        }

        if(animalToInteract != null){
            System.out.print("Would you like to feed " + animalToInteract.name + "? (yes/no): ");
            String feedResponse = sc.nextLine();
            if(feedResponse.equalsIgnoreCase("yes")){
                animalToInteract.eat();
                animalToInteract.makeSound();
            }else if(feedResponse.equalsIgnoreCase("no")){
                System.out.println(animalToInteract.name + " is not hungry right now.");
            }else{
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        } else {
            // If no interactable animal found after dynamic selection
            System.out.println("There is no interactable (healthy) animal in this enclosure right now.");
        }
    }
    private void visitShop() {
        System.out.println("\n===Zoo Shop===");
        double total = 0.0;
        List<Shop> purchasedItems = new ArrayList<>();

        boolean isShopping = true;
        while(isShopping){
            System.out.println("Available Products");
            if (zooData.shopInventory == null || zooData.shopInventory.isEmpty()){
                System.out.println("No products available right now.");
                isShopping = false;
                continue;
            }
            for(Shop product: zooData.shopInventory){
                System.out.println(product.toStringShop());
            }
            System.out.println("0. To proceed to checkout/exit.");
            System.out.print("Enter the numbers of the items you want to buy: ");

            int choice = getUserChoice();
            if(choice==0){
                isShopping = false;
            }else{
                Shop selectedProduct = null;
                for(Shop p : zooData.shopInventory){
                    if(p.getId()==choice){
                        selectedProduct = p;
                        break;
                    }
                }
                if(selectedProduct != null){
                    System.out.println("Selected: " + selectedProduct.getProductName() + " (₱" + String.format("%.0f", selectedProduct.getPrice()) + ")" );
                    purchasedItems.add(selectedProduct);
                    total += selectedProduct.getPrice();
                    System.out.println("Total: ₱" + String.format("%.0f", total));
                }else{
                    System.out.println("Invalid product number. Please try again.");
                }
            }
        }
        if(total>0){
            System.out.print("Proceed to checkout? (yes/no): ");
            String checkoutResponse = sc.nextLine().toLowerCase();

            if(checkoutResponse.equals("yes")){
                System.out.println("Payment successful!");
                System.out.println("Receipt:");
                for(Shop item: purchasedItems){
                    System.out.println("- " + item.getProductName() + ": ₱" + String.format("%.0f", item.getPrice()));
                }
                System.out.println("Total Paid: ₱" + String.format("%.0f", total));
            } else{
                System.out.println("Purchase failed.");
            }
            System.out.println("\nWhat would you like to do next?");
            System.out.println("Choose an option: ");
        }
    }
    private void visitVet(){
        //display menu
        //if view sick animals, then getanimals currently in hospital (ishealthy=false?)
        //if view healed animals, then display healedanimals list with timestamps
        //if attend science lecture, print handler + string statement
        //if heal animals, then iterate through animals in hospital and return to their corresponding enclosure
        //if 5 then exit

        boolean inVetHospital = true;

        String vetName = "Dr. Vet";
        if (zooData.getHandlerArrayList() != null && !zooData.getHandlerArrayList().isEmpty()) {
            for (Handler handler : zooData.getHandlerArrayList()) {
                if (handler.getLocation() != null && handler.getLocation().equals(zooData.hospitalBuilding)) {
                    vetName = handler.getName();
                    break;
                }
            }
        }

        while(inVetHospital){
            System.out.println("\n===Zoo Visitor Hospital Monitor==="); // Matches sample
            System.out.println("1. View Sick Animals");
            System.out.println("2. View Healed Animals");
            System.out.println("3. Attend Science Lecture");
            System.out.println("4. Heal Animals (Veterinarian)"); // Matches sample
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = getUserChoice();
            switch(choice){
                case 1:
                    System.out.println("===Sick Animals Currently in Hospital===");
                    if(zooData.getAnimalsAt("Hospital").isEmpty()){
                        System.out.println("No sick animals in the hospital. All are healthy/discharged.");
                    }else{
                        for(Animal animal : zooData.getAnimalsAt("Hospital")){
                            System.out.println("- " + animal.name);
                        }
                    }
                    break;
                case 2:
                    System.out.println("===Healed Animals with Timestamps: ===");
                    if(zooData.healedAnimalsLog.isEmpty()){
                        System.out.println("No animals have been healed yet.");
                    }else{
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        for(Animal animal : zooData.healedAnimalsLog){
                            System.out.println("- " + animal.name + "/ (" + LocalDateTime.now().format(formatter) + ")");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n" + vetName +" gives a science lecture on an animal health and conservation");
                    break;
                case 4:
                    System.out.println("\n" + vetName + " begins healing sick animals...");
                    //List<Animal> animalsInHospital = zooData.getAnimalsAt("Hospital");
                    if(zooData.getAnimalsAt("Hospital").isEmpty()){
                        System.out.println("No sick animals in the hospital. All are healthy/discharged.");
                        break;
                    }else{
                        for(Animal animal : zooData.getAnimalsAt("Hospital")){
                            animal.isHealthy = true;
                            zooData.healedAnimalsLog.add(animal);
                            //animalsInHospital.remove(animal);
                            if(animal instanceof Pachyderm){
                                animal.setLocation(zooData.pachydermEnclosure);
                            }else if(animal instanceof Bird){
                                animal.setLocation(zooData.birdEnclosure);
                            }else if(animal instanceof Feline){
                                animal.setLocation(zooData.felineEnclosure);
                            }
                            System.out.println("Healed: " + animal.name);
                            System.out.println(animal.name + " has been discharged and returned to their enclosure");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting Zoo Vet Hospital. Goodbye!"); // Matches sample
                    inVetHospital = false;
                    break;
                default:
                    System.out.println("Invalid input. Enter number 1-5");
            }
        }
    }
}
