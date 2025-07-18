package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public abstract class Bird extends Animal {
    public Building location;

    public Bird(String name, Building location) {
        super(name);
        this.location = location;
    }

    public void roam(){
        System.out.println("Bird roam.");
    }

    @Override
    public Building getLocation(){
//        System.out.println("Print <Location> here once method in Building is defined");
        return location;
    }
    public String getName(){
        System.out.printf("Animal's name is %s",this.name);
        return this.name;
    }
    public void setLocation(Building location){
        this.location = location;
    }
    public boolean getHealth(){
        return this.isHealthy;
    }
    public void setHealth(boolean healthValue){
        this.isHealthy = healthValue;
    }
}
