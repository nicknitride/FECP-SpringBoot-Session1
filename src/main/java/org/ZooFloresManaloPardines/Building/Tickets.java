package org.ZooFloresManaloPardines.Building;

public class Tickets extends Shop{

    @Override
    public String toString() {
        return "Tickets";
    }

    public Tickets(int id, String productName, double price) {
        super(id, productName, price);
    }
}
