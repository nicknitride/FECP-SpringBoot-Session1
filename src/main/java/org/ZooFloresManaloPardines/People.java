package org.ZooFloresManaloPardines;

import java.sql.SQLOutput;

public class People {
    private String name;
    private String location;

    public People(String name, String location){
        this.name = name;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void goTo(String newLocation){
        this.location = newLocation;
        System.out.println(name + " is going to " + newLocation);
    }
}
