package org.ZooFloresManaloPardines.Building;

public abstract class Shop extends Building{

    @Override
    public String toString() {
        return "Shop";
    }
    private int id;
    private String productName;
    private double price;

    public Shop(int id, String productName, double price){
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String toStringShop(){
        return id + ". " + productName + " - ₱" + String.format("%.0f", price);
    }
}
