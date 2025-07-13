package org.ZooFloresManaloPardines;


import org.ZooFloresManaloPardines.Animal.Animal;
import org.ZooFloresManaloPardines.Building.*;
import org.ZooFloresManaloPardines.Building.Tickets;
import org.ZooFloresManaloPardines.People.Handler;
import org.ZooFloresManaloPardines.People.Manager;
import org.ZooFloresManaloPardines.People.People;

import java.util.ArrayList;

public class Zoo {
    private ArrayList<People> people;
    private ArrayList<Animal> animals;

    //TicketingModule Shared Data
    private boolean visitorLoggedIn = false;
    private String userTicket;
    private ArrayList<String> ticketInfoArray; //Order: ticket type, price, HolderName
    private Manager admin;
    private ArrayList<Handler> handlerArrayList = new ArrayList<>();
    public Building pachydermEnclosure;
    public Building felineEnclosure;
    public Building birdEnclosure;
    public Building hospitalBuilding;
    public Building giftShop,ticketBooth,restaurant;
    public Zoo(){
        this.people = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.admin = new Manager("Nick", new Drinks(),"admin123");
        pachydermEnclosure =  new PachydermEnclosure();
        felineEnclosure =   new FelineEnclosure();
        birdEnclosure = new BirdEnclosure();
        hospitalBuilding = new Hospital();
        giftShop = new Gifts();
        ticketBooth = new Tickets();
        restaurant = new Food();
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
}
