package org.ZooFloresManaloPardines.Building;

public class Food extends Shop{

    @Override
    public String toString() {
        return "Food";
    }
    public Food(int id, String productName, double price){
        super(id, productName, price);
    }
}
