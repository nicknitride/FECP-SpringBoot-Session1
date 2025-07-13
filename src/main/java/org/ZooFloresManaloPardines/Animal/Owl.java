package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public class Owl extends Bird {
    public Owl(String name, Building location){
        super(name, location);
    }
    @Override
    public void makeSound() {
        System.out.println("Owl sound.");
    }
    @Override
    public void setLocation(Building location){
        super.setLocation(location);
    }
}
