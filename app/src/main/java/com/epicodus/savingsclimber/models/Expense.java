package com.epicodus.savingsclimber.models;


public class Expense {
    String name;
    float cost;

    public Expense() {}

    public Expense(String name, float cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }
}
