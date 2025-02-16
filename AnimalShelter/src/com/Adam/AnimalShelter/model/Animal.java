package com.Adam.AnimalShelter.model;

public abstract class Animal {
    private String name;
    private int arrivalOrder;  // We'll track which animal arrived when.

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    public void setArrivalOrder(int arrivalOrder) {
        this.arrivalOrder = arrivalOrder;
    }
}