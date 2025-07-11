package org.ZooFloresManaloPardines;

public class Falcon extends Bird{
    Falcon(String name, Building location){
        this.name = name;
        this.location = location;
    }
    @Override
    public void makeSound() {
        System.out.println("Falcon sound.");
    }
}
