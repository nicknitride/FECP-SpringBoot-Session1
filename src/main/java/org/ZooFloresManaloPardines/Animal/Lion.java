package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public class Lion extends Feline {
    public Lion(String name, Building location){
        super(name, location);
    }
    @Override
    public void makeSound() {
        System.out.println("Lion sound.");
    }
}
