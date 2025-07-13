package org.ZooFloresManaloPardines.Building;

import org.ZooFloresManaloPardines.Animal.Animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Enclosure extends Building{
    public String name;
    public List<Animal> animals;

    public Enclosure(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }
    //add animal to enclosure
    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }
    //get list of animals in enclosure
    public List<Animal> getAnimals(){
        return animals;
    }

    @Override
    public String toString(){
        return "Enclosure";
    }
}
