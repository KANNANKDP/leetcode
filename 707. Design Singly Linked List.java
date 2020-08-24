# Singly linked list

public class Node {
    int val;
    Node next;
    
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}


class MyLinkedList {

    int length;
    Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.length = 0;
        this.head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= this.length) {
            return -1;
        }
        
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        return current.val;
        
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        this.length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        
        Node newNode = new Node(val);
        
        Node current = head;
        for (int i = 0; i < this.length - 1; i++) {
            current = current.next;
        }
        
        current.next = newNode;
        this.length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        } else if (index == this.length) {
            addAtTail(val);
            return;
        }
        
        Node newNode = new Node(val);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        this.length++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.length) {
            return;
        }
        
        if (index == 0) {
            head = head.next;
            this.length--;
            return;
        }
        
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        current.next = current.next.next;
        this.length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
