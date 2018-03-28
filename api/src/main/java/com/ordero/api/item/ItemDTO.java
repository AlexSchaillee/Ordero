package com.ordero.api.item;

public class ItemDTO {

    private String name;
    private String description;
    private double price;
    private int amount;

    private ItemDTO(){}

    public static ItemDTO itemDTO(){
        return new ItemDTO();
    }

    public ItemDTO withName(String name){
        this.name = name;
        return this;
    }

    public ItemDTO withDescription(String description){
        this.description = description;
        return this;
    }

    public ItemDTO withPrice(double price){
        this.price = price;
        return this;
    }

    public ItemDTO withAmount(int amount){
        this.amount = amount;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
