package com.ordero.domain.item;

import java.util.Objects;
import java.util.UUID;

public class Item {

    private UUID id;
    private String name;
    private String description;
    private double price;
    private int amount;

    private Item(String name, String description, double price, int amount) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public Item setId(UUID id){
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 &&
                amount == item.amount &&
                Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, price, amount);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public static class ItemBuilder {

        private String name;
        private String description;
        private double price;
        private int amount;

        public static ItemBuilder itemBuilder(){
            return new ItemBuilder();
        }

        public ItemBuilder withName(String name){
            this.name = name;
            return this;
        }

        public ItemBuilder withDescription(String description){
            this.description = description;
            return this;
        }

        public ItemBuilder withPrice(double price){
            this.price = price;
            return this;
        }

        public ItemBuilder withAmount(int amount){
            this.amount = amount;
            return this;
        }

        public Item build(){
            return new Item(name,description,price,amount);
        }
    }
}
