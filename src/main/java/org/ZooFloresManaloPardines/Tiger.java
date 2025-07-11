package org.ZooFloresManaloPardines;

public class Tiger extends Feline{
    Tiger(String name, Building location){
        this.name = name;
        this.location = location;
    }
    @Override
    public void makeSound() {
        System.out.println("Tiger sound.");
    }
}
