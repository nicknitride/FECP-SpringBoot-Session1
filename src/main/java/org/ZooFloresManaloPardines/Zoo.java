package org.ZooFloresManaloPardines;


import org.ZooFloresManaloPardines.Animal.Animal;
import org.ZooFloresManaloPardines.Building.*;
import org.ZooFloresManaloPardines.Building.Tickets;
import org.ZooFloresManaloPardines.People.Manager;
import org.ZooFloresManaloPardines.People.People;

import java.util.ArrayList;

public class Zoo {
    private ArrayList<Building> buildings;
    private ArrayList<People> people;
    private ArrayList<Animal> animals;
    private People admin;

    //TicketingModule Shared Data
    private boolean visitorLoggedIn = false;
    private String userTicket;
    private ArrayList<String> ticketInfoArray; //Order: ticket type, price, HolderName

    public Zoo(){
        this.buildings = new ArrayList<>();
        this.people = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.buildings.add(new Tickets());
        this.admin = new People("Admin", buildings.getFirst());
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
}
