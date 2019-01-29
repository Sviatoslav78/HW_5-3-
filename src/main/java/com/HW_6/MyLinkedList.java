package com.HW_6;


public class MyLinkedList {

    Node head;
    Node tail;
    int size = 0;

    public void add(Object data) {

        Node node = new Node(data);

        if (tail == null) {
            head = node;
            tail = node;

        } else {
            tail.nextNode = node;
            tail = node;

        }
        size++;
    }

    public Node delete(Object data) {

        Node nodeToReturn = null;

        if (size == 0) {
            return null;
        }
        if (size == 1) {
            nodeToReturn = head;
            head = null;
            tail = null;
            size--;
            return nodeToReturn;
        }

        Node nodeBeforeNodeToDelete = findNodeBefore(data);
        if (nodeBeforeNodeToDelete.data == null) { // deletion a head-element

            head = head.nextNode;

        } else if (nodeBeforeNodeToDelete != null) {

            if (tail.data == data) { //delete tail-element

                nodeBeforeNodeToDelete.nextNode = null;
                tail = nodeBeforeNodeToDelete;

            } else {
                nodeBeforeNodeToDelete.nextNode = nodeBeforeNodeToDelete.nextNode.nextNode;
            }
            size--;

        }

        return null;
    }

    public Node findNodeBefore(Object data) { // if returns empty Node, then we are deleting head-element
        // if returns null - there is no match
        // returns node if match is found
        if (head.data == data) {
            return new Node();
        }

        Node node = head; // node as the iterator

        while (node.nextNode.data != null) { // iteration through linked lsit
            node = node.nextNode;

            if (node.nextNode.data == data) {
                return node;
            }

            node = node.nextNode;
        }

        return null;

    }

    public Node find(Object data) {

        if (head == null) { // check the first element for a match
            return null;
        }

        if (head.data == data) {
            return head;
        }

        Node node = head; // node as the iterator

        while (node.nextNode != null) { // iteration through linked lsit
            node = node.nextNode;

            if (node.data == data) {
                return node;
            }
        }

        return null;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        Node node = head;
        while (node.nextNode != null) {
            node = null;

        }

    }
}
