package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public class Elephant extends Pachyderm{
    public Elephant(String name, Building location){
        super(name, location);
    }

    @Override
    public void makeSound() {
        System.out.println("Elephant sound.");
    }
}
