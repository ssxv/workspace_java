package com.satyendra.linkedlist;

/**
 * SinglyLinkedList
 * <p>
 * Created by Satyendra on 19/01/17.
 */
public class SinglyLinkedList {

    /**
     * class used as Node for singly linked list.
     */
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    int length;

    SinglyLinkedList() {
    }

    /**
     * contruct singly linked list from an array.
     * @param array
     */
    SinglyLinkedList(int[] array) {
        Node start = null;
        for (int i = array.length - 1; i >= 0; --i) {
            Node newNode = new Node(array[i]);
            newNode.next = start;
            start = newNode;
        }
        this.head = start;
        this.length = array.length;
    }

    /**
     * method to insert data at an index.
     *
     * @param index
     * @param data
     */
    public void insert(int index, int data) {
        Node start = head;
        if (index < length) {
            for (int i = 0; i < index - 1; ++i) {
                start = start.next;
            }
            Node newNode = new Node(data);
            newNode.next = start.next;
            start.next = newNode;
            length++;
        }
    }

    /**
     * method to reverse a singly linked list.
     */
    public void reverse() {
        Node pre = null;
        Node cur = head;
        Node nxt = head.next;
        while (nxt != null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            nxt = nxt.next;
        }
        cur.next = pre;
        head = cur;
    }

    /**
     * method to display a singly linked list.
     */
    public void display() {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + ", ");
            start = start.next;
        }
        System.out.println();
    }

    /**
     * main method, to test singly linked list.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        SinglyLinkedList s = new SinglyLinkedList(a);
        s.display();
        s.insert(5, 9);
        s.display();
        s.reverse();
        s.display();
    }

}
