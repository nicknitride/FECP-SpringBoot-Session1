package org.ZooFloresManaloPardines;

public class Rhino extends Pachyderm{
    Rhino(String name, Building location){
        this.name = name;
        this.location = location;
    }
    @Override
    public void makeSound() {
        System.out.println("Rhino sound.");
    }
}
