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
}
