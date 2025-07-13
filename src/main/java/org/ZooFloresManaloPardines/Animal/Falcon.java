package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public class Falcon extends Bird {
    public Falcon(String name, Building location){
        super(name, location);
    }
    @Override
    public void makeSound() {
        System.out.println("Falcon sound.");
    }
}
