package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public class Cheetah extends Feline{
    public Cheetah(String name, Building location){
        super(name, location);
        this.location = location;
    }
    @Override
    public void makeSound() {
        System.out.println("Cheetah sound.");
    }
    @Override
    public void setLocation(Building location){
        super.setLocation(location);
    }
}
