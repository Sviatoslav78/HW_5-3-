package com.HW_6;

public class Node {

    Object data;
    Node nextNode;

    public Node(Object data) {
        this.data = data;
    }

    public Node() {

    }

    @Override
    public String toString() {
        return "" + data;
    }
}
