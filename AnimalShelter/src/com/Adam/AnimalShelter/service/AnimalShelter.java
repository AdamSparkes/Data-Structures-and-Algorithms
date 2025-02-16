package com.Adam.AnimalShelter.service;

import com.Adam.AnimalShelter.model.Cat;
import com.Adam.AnimalShelter.model.Dog;
import com.Adam.AnimalShelter.model.Animal;
import com.Adam.AnimalShelter.queue.QueueArray;

import java.util.HashMap;
import java.util.Map; //I'm using HashMap because the QueueArray only stores ints when I need to store and recieve
//animal objects and be able to differenciate between cats and dogs depending on what was selected.
//This method was suggested to my by a friend when I was trying to figure out how to solve this problem, from there I did
//personal resreach on HashMap and how to implement it here to achieve my goal.

public class AnimalShelter {

    private QueueArray dogQueue;
    private QueueArray catQueue;
    private Map<Integer, Animal> arrivalMap;
    private int orderCounter;

    public AnimalShelter(int dogCapacity, int catCapacity) {
        this.dogQueue = new QueueArray(dogCapacity);
        this.catQueue = new QueueArray(catCapacity);
        this.arrivalMap = new HashMap<>();
        this.orderCounter = 0;
    }

    public void enqueue(Animal animal) {

        animal.setArrivalOrder(orderCounter);
        arrivalMap.put(orderCounter, animal);
        orderCounter++;

        if (animal instanceof Dog) {
            dogQueue.enQueue(animal.getArrivalOrder());
        } else if (animal instanceof Cat) {
            catQueue.enQueue(animal.getArrivalOrder());
        }
    }

    public Animal dequeueAny() {

        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            return null;
        }

        if (dogQueue.isEmpty()) {
            return dequeueCat();
        }

        if (catQueue.isEmpty()) {
            return dequeueDog();
        }

        int oldestDogOrder = dogQueue.peek();
        int oldestCatOrder = catQueue.peek();

        if (oldestDogOrder < oldestCatOrder) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Animal dequeueDog() {
        if (dogQueue.isEmpty()) {
            return null;
        }
        int dogOrder = dogQueue.deQueue();   // Get the dog's arrivalOrder
        Animal dog = arrivalMap.remove(dogOrder); // Remove from map and return
        return dog;
    }

    public Animal dequeueCat() {
        if (catQueue.isEmpty()) {
            return null;
        }
        int catOrder = catQueue.deQueue();   // Get the cat's arrivalOrder
        Animal cat = arrivalMap.remove(catOrder); // Remove from map
        return cat;
    }
}
