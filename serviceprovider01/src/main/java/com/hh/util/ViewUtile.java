package com.hh.util;

import java.util.Arrays;
import java.util.LinkedList;

public class ViewUtile {



    public static void main (String[] args){
        Node node1=new Node(0);
        Node node2=new Node(1);
        Node node3=new Node(2);
        Node node4=new Node(3);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=null;
        System.out.println("args = " + node1.value);
        System.out.println("args = " + node2.value);
        System.out.println("args = " + node3.value);
        System.out.println("args = " + node4.value);
       Node n= reverse(node1);
        System.out.println("args = " + node1.value);
        System.out.println("args = " + node2.value);
        System.out.println("args = " + node3.value);
        System.out.println("args = " + node4.value);
new StringBuilder("abcd").reverse().toString();
       //Node= reverse(Node);


    }
    public static  Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }
}
class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
        this.next=null;
    }


}