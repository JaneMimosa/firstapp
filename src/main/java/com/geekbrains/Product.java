package com.geekbrains;

public class Product {
    int id;
    String title;
    int cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String show() {
        return "ID: " + this.id + " | Title: " + this.title + " | Cost: " + this.cost;
    }
}
