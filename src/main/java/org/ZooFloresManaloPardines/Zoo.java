package org.ZooFloresManaloPardines;


import org.ZooFloresManaloPardines.Animal.*;
import org.ZooFloresManaloPardines.Building.*;
import org.ZooFloresManaloPardines.Building.Tickets;
import org.ZooFloresManaloPardines.People.Handler;
import org.ZooFloresManaloPardines.People.Manager;
import org.ZooFloresManaloPardines.People.People;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private ArrayList<People> people;
    private ArrayList<Animal> animals;

    public List<Animal> healedAnimalsLog;
    public List<Animal> animalsInHospital;


    //TicketingModule Shared Data
    private boolean visitorLoggedIn = false;
    private String userTicket;
    private ArrayList<String> ticketInfoArray; //Order: ticket type, price, HolderName
    private Manager admin;
    private ArrayList<Handler> handlerArrayList = new ArrayList<>();
    //changed to declare as enclosure not building
    public Enclosure pachydermEnclosure;
    public Enclosure felineEnclosure;
    public Enclosure birdEnclosure;
    public Building hospitalBuilding;
    public Building giftShop,ticketBooth,restaurant;

    public List<Shop> shopInventory;
    public Zoo(){
        this.people = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.healedAnimalsLog = new ArrayList<>();
        this.animalsInHospital = new ArrayList<>();
        this.shopInventory = new ArrayList<>();
        this.admin = new Manager("admin", new Drinks(003, "coke", 20.00),"admin");
        pachydermEnclosure =  new PachydermEnclosure("Pachyderm (Elephant)");
        felineEnclosure =   new FelineEnclosure("Feline (Lion)");
        birdEnclosure = new BirdEnclosure("Bird (Owl)");
        hospitalBuilding = new Hospital();
        giftShop = new Gifts(001, "Gift shop item 1", 10.00);
        ticketBooth = new Tickets(003, "ticket", 0.00);
        restaurant = new Food(002, "hotdog food", 15.00);

        //populating enclosures with animals
        Elephant dumbo = new Elephant("Dumbo", pachydermEnclosure);
        Rhino rhinoMan = new Rhino("Rhino Man", pachydermEnclosure);
        Hippo harry = new Hippo("Harry", pachydermEnclosure);
        pachydermEnclosure.addAnimal(dumbo);
        pachydermEnclosure.addAnimal(rhinoMan);
        pachydermEnclosure.addAnimal(harry);
        animals.add(dumbo);
        animals.add(rhinoMan);
        animals.add(harry);

        Lion simba = new Lion("Simba", felineEnclosure);
        Tiger tigger = new Tiger("Tigger", felineEnclosure);
        Cheetah cheetah = new Cheetah("Cheetah", felineEnclosure);
        felineEnclosure.addAnimal(simba); // FIX: Add to enclosure
        felineEnclosure.addAnimal(tigger); // FIX: Add to enclosure
        felineEnclosure.addAnimal(cheetah); // FIX: Add to enclosure
        animals.add(simba);
        animals.add(tigger);
        animals.add(cheetah);

        Owl hedwig = new Owl("Hedwig", birdEnclosure);
        Parrot parrotMan = new Parrot("Parrot Man", birdEnclosure);
        Falcon marvinBeak = new Falcon("Flyer", birdEnclosure);
        birdEnclosure.addAnimal(hedwig); // FIX: Add to enclosure
        birdEnclosure.addAnimal(parrotMan); // FIX: Add to enclosure
        birdEnclosure.addAnimal(marvinBeak); // FIX: Add to enclosure
        animals.add(hedwig);
        animals.add(parrotMan);
        animals.add(marvinBeak);

        this.shopInventory = new ArrayList<>();
        shopInventory.add(new Drinks(1, "Soft Drink", 30.00));
        shopInventory.add(new Food(2, "Popcorn", 50.00));
        shopInventory.add(new Gifts(3, "Plush Toy", 120.00));
        shopInventory.add(new Gifts(4, "Keychain", 45.00));
    }

    public boolean getVisitorLoggedIn(){
        return visitorLoggedIn;
    }

    public void setVisitorLoggedIn(boolean visitorLoggedIn){
        this.visitorLoggedIn = visitorLoggedIn;
    }
    public void setUserTicketNumber(String ticketNumber){
        userTicket = ticketNumber;
        System.out.println("Set user ticket: "+userTicket);
    }
    public void setUserInfoArray(ArrayList<String> userInfo){
        ticketInfoArray = userInfo;
    }
    public ArrayList<String> getUserInfoArray(){
        return ticketInfoArray;
    }
    public String getUserTicket(){
        return userTicket;
    }

    public Manager getAdminObject(){
        return this.admin;
    }
    public void addHandlerToZoo(Handler handler){
        handlerArrayList.add(handler);
    }
    public ArrayList<Handler> getHandlerArrayList(){
        return handlerArrayList;
    }
    public ArrayList<Animal> getAnimalsAt(String location){
        ArrayList<Animal> animalsAt = new ArrayList<>();
        for (Animal animal : this.animals) {
            if (animal.getLocation().toString().equals(location)) {
                animalsAt.add(animal);
            }
        }
        return animalsAt;
    }

}
