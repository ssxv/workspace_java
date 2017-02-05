package com.satyendra.binaryHeap;

/**
 * A Binary Heap is a Binary Tree with following properties.
 * It’s a complete tree (All levels are completely filled except possibly the
 * last level and the last level has all keys as left as possible).
 * This property of Binary Heap makes them suitable to be stored in an array.
 * <p>
 * Binary Heap implemented as Min-Heap
 * This doesn't use Node, like in BinarySearchTree.
 * Instead an array is used.
 * <p>
 * Created by Satyendra on 04/02/17.
 */
public class MinHeap {

    private int[] minHeap;
    private int size;

    MinHeap(int capacity) {
        minHeap = new int[capacity];
    }

    /**
     * method to insert in a minHeap
     *
     * @param data
     */
    public void insert(int data) {
        if (size == minHeap.length) {
            System.out.println("Heap is full !!");
            return;
        }

        // First insert the new key at the end
        size++;
        int i = size - 1;
        minHeap[i] = data;

        // Fix the min heap property if it is violated
        while (i != 0 && minHeap[parent(i)] > minHeap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void swap(int i, int j) {
        int temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
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
     * method to remove the min element, or the root element from minHeap.
     */
    public void deleteMin() {
        if (size <= 0) {
            System.out.println("Heap is empty !!");
            return;
        }
        if (size == 1) {
            size--;
            return;
        }

        // set last element at root and heapify.
        minHeap[0] = minHeap[size - 1];
        size--;
        heapify(0);
        return;
    }

    /**
     * method to heapify the minHeap.
     *
     * @param i
     */
    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < size && minHeap[l] < minHeap[i]) {
            smallest = l;
        }
        if (r < size && minHeap[r] < minHeap[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    /**
     * method to get min value, root from minHeap.
     */
    public void getMin() {
        System.out.println(minHeap[0]);
    }

    /**
     * method to decrease the value at an index in minHeap.
     *
     * @param index
     * @param newValue
     */
    public void decreaseKey(int index, int newValue) {
        if (index >= size) {
            System.out.println("Index out of Heap bound !!");
            return;
        }
        if (minHeap[index] <= newValue) {
            System.out.println("Provide a smaller value !!");
            return;
        }
        minHeap[index] = newValue;
        while (index != 0 && minHeap[parent(index)] > minHeap[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    /**
     * methof to display minHeap.
     */
    public void display() {
        for (int i = 0; i < size; ++i) {
            System.out.print(minHeap[i] + ", ");
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
        decreaseKey(index, Integer.MIN_VALUE);
        heapify(0);
        deleteMin();
    }

    /**
     * main method, test min-heap.
     *
     * @param args
     */
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(11);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(40);
        minHeap.insert(60);
        minHeap.insert(50);
        minHeap.insert(30);
        minHeap.insert(80);
        minHeap.insert(90);
        minHeap.insert(70);

        minHeap.display();
        minHeap.delete(7);
        minHeap.display();
    }
}
