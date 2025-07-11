package org.ZooFloresManaloPardines.Animal;

import org.ZooFloresManaloPardines.Building.Building;

public abstract class Pachyderm extends Animal {
    public Building location;
    public void roam(){
        System.out.println("Pachyderm roam.");
    }
}
