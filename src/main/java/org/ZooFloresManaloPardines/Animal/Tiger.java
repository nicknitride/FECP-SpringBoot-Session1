package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public class Tiger extends Feline{
    public Tiger(String name, Building location){
        super(name, location);
    }
    @Override
    public void makeSound() {
        System.out.println("Tiger sound.");
    }
}
