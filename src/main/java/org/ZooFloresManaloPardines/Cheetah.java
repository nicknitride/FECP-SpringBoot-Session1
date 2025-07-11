package org.ZooFloresManaloPardines;

public class Cheetah extends Feline{
    Cheetah(String name, Building location){
        this.name = name;
        this.location = location;
    }
    @Override
    public void makeSound() {
        System.out.println("Cheetah sound.");
    }
}
