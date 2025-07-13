package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public class Rhino extends Pachyderm{
    public Rhino(String name, Building location){
        super(name, location);
    }
    @Override
    public void makeSound() {
        System.out.println("Rhino sound.");
    }
}
