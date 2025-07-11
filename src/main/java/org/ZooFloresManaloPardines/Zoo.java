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

    public Zoo(){
        this.buildings = new ArrayList<>();
        this.people = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.buildings.add(new Tickets());
        this.admin = new People("Admin", buildings.getFirst());

    }
}
