package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public abstract class Feline extends Animal {
    public Building location;

    public Feline(String name, Building location) {
        super(name);
        this.location = location;
    }

    @Override
    public Building getLocation(){
//        System.out.println("Print <Location> here once method in Building is defined");
        return location;
    }

    public void setLocation(Building location){
        this.location = location;
    }
    public void roam(){
        System.out.println("Feline roam.");
    }
    public String getName(){
        System.out.printf("Animal's name is %s",this.name);
        return this.name;
    }
    public boolean getHealth(){
        return this.isHealthy;
    }
    public void setHealth(boolean healthValue){
        this.isHealthy = healthValue;
    }
}
