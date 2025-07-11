package org.ZooFloresManaloPardines.People;

import org.ZooFloresManaloPardines.Building.Building;

import java.sql.SQLOutput;

public class People {
    private String name;
    private Building location;

    public People(String name, Building location){
        this.name = name;
        this.location = location;
    }

    public Building getLocation() {
        return location;
    }

    public void setLocation(Building location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void goTo(String newLocation){
    }
}
