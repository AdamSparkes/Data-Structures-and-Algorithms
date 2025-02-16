package com.Adam.AnimalShelter.queue;

public class QueueArray {
    private int[] arr;
    private int backOfQueue;
    private int nItems;
    private int beginingOfQueue;

    public QueueArray(int size) {
        this.arr = new int[size];
        this.backOfQueue = -1;
        this.beginingOfQueue = -1;
        this.nItems = 0;
        System.out.println("The queue is successfully created with size of: " + size);
    }

    // isFull
    public boolean isFull(){
        return (backOfQueue == arr.length - 1);
    }

    // isEmpty
    public boolean isEmpty(){
        return (nItems == 0);
    }

    // enQueue
    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The Queue is full");
            return;
        }
        if (isEmpty()) {
            beginingOfQueue = 0;
        }
        backOfQueue++;
        arr[backOfQueue] = value;
        nItems++;
        System.out.println("Successfully inserted " + value + " in the queue");
    }

    // deQueue
    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The Queue is empty");
            return -1;
        }
        int result = arr[beginingOfQueue];
        beginingOfQueue++;
        nItems--;
        if (beginingOfQueue > backOfQueue) {
            // Reset queue pointers if it becomes empty
            beginingOfQueue = -1;
            backOfQueue = -1;
        }
        return result;
    }

    // peek
    public int peek(){
        if (isEmpty()){
            System.out.println("The queue is empty");
            return -1;
        }
        return arr[beginingOfQueue];
    }

    // delete entire queue
    public void deleteQueue(){
        arr = null;
        System.out.println("The Queue is successfully deleted");
    }
}
