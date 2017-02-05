package com.satyendra.binaryHeap;

/**
 * A Binary Heap is a Binary Tree with following properties.
 * It’s a complete tree (All levels are completely filled except possibly the
 * last level and the last level has all keys as left as possible).
 * This property of Binary Heap makes them suitable to be stored in an array.
 * <p>
 * Binary Heap implemented as max-heap.
 * <p>
 * Created by Satyendra on 05/02/17.
 */
public class MaxHeap {
    private int[] maxHeap;
    private int size;

    MaxHeap(int capacity) {
        maxHeap = new int[capacity];
    }

    /**
     * method to insert in a maxHeap
     *
     * @param data
     */
    public void insert(int data) {
        if (size == maxHeap.length) {
            System.out.println("Heap is full !!");
            return;
        }

        // First insert the new key at the end
        size++;
        int i = size - 1;
        maxHeap[i] = data;

        // Fix the min heap property if it is violated
        while (i != 0 && maxHeap[parent(i)] < maxHeap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void swap(int i, int j) {
        int temp = maxHeap[i];
        maxHeap[i] = maxHeap[j];
        maxHeap[j] = temp;
    }

    /**
     * method to get the index of the parent.
     *
     * @param i
     * @return
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * method to get left child index.
     *
     * @param i
     * @return
     */
    private int left(int i) {
        return (2 * i + 1);
    }


    /**
     * method to get right child index.
     *
     * @param i
     * @return
     */
    private int right(int i) {
        return (2 * i + 2);
    }

    /**
     * method to remove the min element, or the root element from maxHeap.
     */
    public void deleteMax() {
        if (size <= 0) {
            System.out.println("Heap is empty !!");
            return;
        }
        if (size == 1) {
            size--;
            return;
        }

        // set last element at root and heapify.
        maxHeap[0] = maxHeap[size - 1];
        size--;
        heapify(0);
        return;
    }

    /**
     * method to heapify the maxHeap.
     *
     * @param i
     */
    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int greatest = i;
        if (l < size && maxHeap[l] > maxHeap[i]) {
            greatest = l;
        }
        if (r < size && maxHeap[r] > maxHeap[greatest]) {
            greatest = r;
        }
        if (greatest != i) {
            swap(i, greatest);
            heapify(greatest);
        }
    }

    /**
     * method to get min value, root from maxHeap.
     */
    public void getMax() {
        System.out.println(maxHeap[0]);
    }

    /**
     * method to decrease the value at an index in maxHeap.
     *
     * @param index
     * @param newValue
     */
    public void increaseKey(int index, int newValue) {
        if (index >= size) {
            System.out.println("Index out of Heap bound !!");
            return;
        }
        if (maxHeap[index] >= newValue) {
            System.out.println("Provide a greater value !!");
            return;
        }
        maxHeap[index] = newValue;
        while (index != 0 && maxHeap[parent(index)] < maxHeap[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    /**
     * method to display maxHeap.
     */
    public void display() {
        for (int i = 0; i < size; ++i) {
            System.out.print(maxHeap[i] + ", ");
        }
        System.out.println();
    }

    /**
     * method to delete element at an index.
     *
     * @param index
     */
    public void delete(int index) {
        if (index >= size) {
            System.out.println("Index out of Heap bound !!");
            return;
        }
        increaseKey(index, Integer.MAX_VALUE);
        heapify(0);
        deleteMax();
    }

    /**
     * main method, test max-heap.
     *
     * @param args
     */
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(11);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(40);
        maxHeap.insert(60);
        maxHeap.insert(50);
        maxHeap.insert(30);
        maxHeap.insert(80);
        maxHeap.insert(90);
        maxHeap.insert(70);

        maxHeap.display();
        maxHeap.delete(7);
        maxHeap.display();
    }
}
