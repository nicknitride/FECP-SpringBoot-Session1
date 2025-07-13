package org.ZooFloresManaloPardines.People;

import org.ZooFloresManaloPardines.People.People;
import org.ZooFloresManaloPardines.Building.*;
import org.ZooFloresManaloPardines.ZooAdmin;

public class Manager extends People {
    private boolean isZooOpen;
    public Manager(String name, Building location,String password){
        super(name, location);
        ZooAdmin.setUserName(name);
        ZooAdmin.setPassword(password);
    }
    public void closeZoo(){
        isZooOpen = false;
        System.out.println("Manager is closing zoo.");
    }
    public void openZoo(){
        isZooOpen = true;
        System.out.println("Manager has opened zoo.");
    }
    public boolean getZooOpenStatus(){
//        System.out.print("Zoo open is set to: \n"+isZooOpen);
        return isZooOpen;
    }
}
