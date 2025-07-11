package org.ZooFloresManaloPardines;

public abstract class Animal {
    public String name;
    public boolean isHealthy;

    public void eat(){
        System.out.println("Eating from animal class.");
    };
    public void sleep(){
        System.out.println("Sleeping from class");
    };
    public abstract void roam();
    public abstract void makeSound();
}
