package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public class Hippo extends Pachyderm {
    public Hippo(String name, Building location){
        super(name, location);
    }
    @Override
    public void makeSound() {
        System.out.println("Hippo sound.");
    }
}
