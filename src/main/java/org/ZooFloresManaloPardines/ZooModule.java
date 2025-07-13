package org.ZooFloresManaloPardines;

import org.ZooFloresManaloPardines.Animal.*;
import org.ZooFloresManaloPardines.Building.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ZooModule {
    private Scanner sc;
    private List<Enclosure> enclosures;
    private Zoo zooData;

    private List<Shop> shopProducts;

    //representative animals for direct interaction in visitEnclosure()?
    private Animal representativeLion;
    private Animal representativeElephant;
    private Animal representativeOwl;

    public ZooModule(Zoo zooData) {
        this.sc = new Scanner(System.in);
        this.enclosures = new ArrayList<>();
        this.zooData = zooData;
        this.shopProducts = new ArrayList<>();
        initializeZooData();
    }

    private void initializeZooData() {
        //based from sample output
        //init enclosures and animals
        PachydermEnclosure pachydermEnclosure = new PachydermEnclosure("Pachyderm (Elephant)");
        FelineEnclosure felineEnclosure = new FelineEnclosure("Feline (Lion)");
        BirdEnclosure birdEnclosure = new BirdEnclosure("Bird (Owl)");
        //pachyderm
        Elephant dumbo = new Elephant("Dumbo", pachydermEnclosure);
        Rhino horn = new Rhino("Horn", pachydermEnclosure);
        Hippo harry = new Hippo("Harry", pachydermEnclosure);
        pachydermEnclosure.addAnimal(dumbo);
        pachydermEnclosure.addAnimal(horn);
        pachydermEnclosure.addAnimal(harry);
        this.representativeElephant = dumbo;
        //feline
        Lion simba = new Lion("Simba", felineEnclosure);
        Tiger stripes = new Tiger("Stripes", felineEnclosure);
        Cheetah speedy = new Cheetah("Speedy", felineEnclosure);
        felineEnclosure.addAnimal(simba);
        felineEnclosure.addAnimal(stripes);
        felineEnclosure.addAnimal(speedy);
        this.representativeLion = simba;
        //bird
        Owl hedwig = new Owl("Hedwig", birdEnclosure);
        Parrot polly = new Parrot("Polly", birdEnclosure);
        Falcon flyer = new Falcon("Flyer", birdEnclosure);
        birdEnclosure.addAnimal(hedwig);
        birdEnclosure.addAnimal(polly);
        birdEnclosure.addAnimal(flyer);
        this.representativeOwl = hedwig;

        enclosures.add(pachydermEnclosure);
        enclosures.add(felineEnclosure);
        enclosures.add(birdEnclosure);

        //init shop products
        //shopProducts.add(new Drinks(1, "Soft Drink", 30.00));
        //shopProducts.add(new Food(2, "Popcorn", 50.00));
        //shopProducts.add(new Gifts(3, "Plush Toy", 120.00));
        //shopProducts.add(new Gifts(4, "Keychain", 45.00));
    }

    public void startZooModule(){
        System.out.println("Welcome to the Zoo Baby");
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
                    visitVetereniarian();
                    break;
                case 4:
                    System.out.println("Thank you for visiting good bye");
                    inZoo = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter a number from 1-4");
            }
        }
        sc.close();
    }

    private void displayZooMainMenu(){
        System.out.println("\n1. Visit Enclosure");
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
        for(int i=0;i<enclosures.size();i++){
            System.out.println((i+1) + ". " + enclosures.get(i).name);
        }
        System.out.println("0. Back to Zoo Main Menu");
        System.out.print("Choose an option: ");

        int choice = getUserChoice();
        Animal animalToInteract = null;
        if(choice>0 && choice<=enclosures.size()){
            Enclosure selectedEnclosure = enclosures.get(choice-1);
            System.out.println("@ " + selectedEnclosure.name); //enclosure checker
            if(choice==1){
                animalToInteract = representativeElephant;
            }else if(choice==2){
                animalToInteract = representativeLion;
            }else if(choice==3){
                animalToInteract = representativeOwl;
            }
            if(animalToInteract != null){
                System.out.print("Would you like to feed " + animalToInteract.name + "? (yes/no): ");
                String feedResponse = sc.nextLine();
                if(feedResponse.equalsIgnoreCase("yes")){
                    animalToInteract.eat();
                    animalToInteract.makeSound();
                }else if(feedResponse.equalsIgnoreCase("no")){
                    System.out.println(animalToInteract.name + "despises you for not feeding it.");
                }else{
                    System.out.println("Invalid input.");
                }
            }
            System.out.println("\nWhat would you like to do next?");
            //System.out.print("Choose an option: ");
        }else{
            System.out.println("Invalid choice. Please select from 1-3.");
        }
    }
    private void visitShop() {}
    private void visitVetereniarian(){}
}
