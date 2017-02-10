package com.satyendra.linkedlist;

import com.satyendra.binarySearchTree.Node;

/**
 * Doubly Linked List
 * <p>
 * Created by Satyendra on 06/02/17.
 */
public class DoublyLinkedList {

    /**
     * class used as Node for doubly linked list.
     */
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node start;
    private Node end;
    private int length;

    /**
     * construct a doubly linked list from an array.
     *
     * @param array
     */
    public DoublyLinkedList(int[] array) {
        if (array.length > 1) {
            Node n = new Node(array[0]);
            start = n;
            end = n;
        }
        for (int i = 1; i < array.length; ++i) {
            Node n = new Node(array[i]);
            end.next = n;
            n.prev = end;
            end = n;
        }
        length = array.length;
    }

    /**
     * insert at end.
     *
     * @param data
     */
    private void insert(int data) {
        Node n = new Node(data);
        end.next = n;
        n.prev = end;
        end = n;
        length++;
    }

    /**
     * insert at a position.
     *
     * @param position
     * @param data
     */
    private void insert(int position, int data) {
        if (position > length) {
            System.out.println("Out of List bound !!");
            return;
        }
        if (position == 0) {
            Node n = new Node(data);
            n.next = start;
            start.prev = n;
            start = n;
            length++;
            return;
        }
        if (position == length) {
            Node n = new Node(data);
            end.next = n;
            n.prev = end;
            end = n;
            length++;
            return;
        }
        Node temp = start;
        for (int i = 0; i < position-1; ++i) {
            temp = temp.next;
        }
        Node n = new Node(data);
        n.next = temp.next;
        temp.next.prev = n;
        n.prev = temp;
        temp.next = n;
    }

    /**
     * method to display the list.
     */
    private void display() {
        Node temp = start;
        while (temp!=null){
            System.out.print(temp.data+", ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * main method, to test doubly linked list.
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        DoublyLinkedList d = new DoublyLinkedList(a);
        d.insert(3, 9);
        d.display();
    }

}
