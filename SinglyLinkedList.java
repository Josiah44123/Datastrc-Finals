import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList implements Iterable<String> {
    
    private Node head;
    private Node tail;
    private int size;
    
    // Inner Node class
    private static class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Constructor
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    // O(1) - Add at the beginning
    public void addFirst(String value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
   
    // O(1) - Add at the end using tail pointer
    public void addLast(String value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    // O(n) - Insert at specific index
    public void insertAt(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        
        if (index == 0) {
            addFirst(value);
            return;
        }
        
        if (index == size) {
            addLast(value);
            return;
        }
        
        Node newNode = new Node(value);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
    // O(n) - Get element at index
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // O(n) - Set element at index
    public String set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        String oldValue = current.data;
        current.data = value;
        return oldValue;
    }
    
    // O(1) - Remove first element
    public String removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        String removedData = head.data;
        head = head.next;
        size--;
        
        if (isEmpty()) {
            tail = null;
        }
        
        return removedData;
    }
    
    // O(n) - Remove last element
    public String removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        if (size == 1) {
            String removedData = head.data;
            head = tail = null;
            size--;
            return removedData;
        }
        
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        
        String removedData = tail.data;
        current.next = null;
        tail = current;
        size--;
        
        return removedData;
    }
    
    // O(n) - Remove element at index
    public String removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        if (index == 0) {
            return removeFirst();
        }
        
        if (index == size - 1) {
            return removeLast();
        }
        
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        String removedData = current.next.data;
        current.next = current.next.next;
        size--;
        
        return removedData;
    }
    
    // O(n) - Find index of element
    public int indexOf(Object o) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(current.data, o)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    
    // O(n) - Check if list contains element
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    
    // O(1) - Clear the list
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    // String representation
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
    
    // Iterator implementation
    @Override
    public Iterator<String> iterator() {
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator<String> {
        private Node current = head;
        
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String data = current.data;
            current = current.next;
            return data;
        }
    }
}