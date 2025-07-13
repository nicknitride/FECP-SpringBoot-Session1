package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public class Parrot extends Bird {
    public Parrot(String name, Building location){
        super(name, location);
    }
    @Override
    public void makeSound() {
        System.out.println("Parrot sound.");
    }
}
