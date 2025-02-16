package com.Adam.AnimalShelter;

import com.Adam.AnimalShelter.model.Cat;
import com.Adam.AnimalShelter.model.Dog;
import com.Adam.AnimalShelter.model.Animal;
import com.Adam.AnimalShelter.service.AnimalShelter;

public class Main {
    public static void main(String[] args) {
        // Create a shelter that can hold up to 5 dogs and 5 cats
        AnimalShelter shelter = new AnimalShelter(5, 5);

        // Enqueue a few animals
        shelter.enqueue(new Dog("Rex"));
        shelter.enqueue(new Cat("Fluffy"));
        shelter.enqueue(new Dog("Buddy"));
        shelter.enqueue(new Cat("Mia"));

        // Test dequeueAny() => should get "Rex" (first in overall)
        Animal oldestAnimal = shelter.dequeueAny();
        if (oldestAnimal != null) {
            System.out.println("DequeueAny => " + oldestAnimal.getName());
        }

        // Test dequeueDog() => should get "Buddy"
        Animal oldestDog = shelter.dequeueDog();
        if (oldestDog != null) {
            System.out.println("DequeueDog => " + oldestDog.getName());
        }

        // Test dequeueCat() => should get "Fluffy"
        Animal oldestCat = shelter.dequeueCat();
        if (oldestCat != null) {
            System.out.println("DequeueCat => " + oldestCat.getName());
        }
    }
}