package org.ZooFloresManaloPardines;

public class Owl extends Bird{
    Owl(String name, Building location){
        this.name = name;
        this.location = location;
    }
    @Override
    public void makeSound() {
        System.out.println("Owl sound.");
    }
}
