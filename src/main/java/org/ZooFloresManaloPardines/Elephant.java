package org.ZooFloresManaloPardines;

public class Elephant extends Pachyderm{
    Elephant(String name, Building location){
        this.name = name;
        this.location = location;
    }

    @Override
    public void makeSound() {
        System.out.println("Elephant sound.");
    }
}
