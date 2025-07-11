package org.ZooFloresManaloPardines;

public class Lion extends Feline{
    Lion(String name, Building location){
        this.name = name;
        this.location = location;
    }
    @Override
    public void makeSound() {
        System.out.println("Lion sound.");
    }
}
