package org.ZooFloresManaloPardines.Animal;

public abstract class Animal {
    public String name;
    public boolean isHealthy;

    public Animal(String name) {
        this.name = name;
        this.isHealthy = true;
    }

    public void eat(){
        System.out.println(name + " is eating.");
    };
    public void sleep(){
        System.out.println("Sleeping from class");
    };
    public abstract void roam();
    public abstract void makeSound();
}
