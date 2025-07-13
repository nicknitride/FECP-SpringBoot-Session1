package org.ZooFloresManaloPardines.Building;

import org.ZooFloresManaloPardines.Building.Shop;

public class Drinks extends Shop {
    @Override
    public String toString() {
        return "Drinks";
    }

    public Drinks(int id, String productName, double price){
        super(id, productName, price);
    }
}
