package org.ZooFloresManaloPardines.Building;

public class Gifts extends Shop{
    @Override
    public String toString() {
        return "Gifts";
    }

    public Gifts(int id, String productName, double price){
        super(id, productName, price);
    }
}
