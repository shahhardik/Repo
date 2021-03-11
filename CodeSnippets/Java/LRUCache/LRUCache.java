package in.shahhardik;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {
    private final int capacity;
    private int size;
    private final Map<String, Node> hashmap;
    private final DoublyLinkedList internalQueue;

    LRUCache(final int capacity) {
        this.capacity = capacity;
        this.hashmap = new HashMap<>();
        this.internalQueue = new DoublyLinkedList();
        this.size = 0;
    }

    public T get(final String key) {
        Node node = hashmap.get(key);
        if(node == null)  {
            return null;
        }
        internalQueue.moveNodeToFront(node);
        return hashmap.get(key).value;
    }

    public void put(final String key, final T value) {
        Node currentNode = hashmap.get(key);
        if( currentNode != null ) {
            currentNode.value = value;
            internalQueue.moveNodeToFront(currentNode);
        }

        if(size == capacity) {
            String rearNodeKey = internalQueue.getRearKey();
            internalQueue.removeNodeFromRear();
            hashmap.remove(rearNodeKey);
            size--;
        }

        Node node = new Node(key,value);
        internalQueue.addNodeToFront(node);
        hashmap.put(key,node);
        size++;
    }

    public void display() {
        internalQueue.display();
    }

    public void delete(final String key) {
        internalQueue.removeNodeByKey(key);
        hashmap.remove(key);
        size--;
    }

    private class Node {
        String key;
        T value;
        Node next, prev;

        public Node(final String key, final T value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private class DoublyLinkedList{
        private Node front, rear;
        public DoublyLinkedList() {
            front=rear=null;
        }

        private void addNodeToFront(final Node node) {
            if(rear == null) {
                front = rear = node;
                return;
            }
            node.next = front;
            front.prev = node;
            front = node;
        }
        private void moveNodeToFront(final Node node) {
            if(front == node) {
                return;
            }

            if(node == rear) {
                rear = rear.prev;
                rear.next = null;
            }
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            node.prev = null;
            node.next = front;
            front.prev = node;
            front = node;
        }

        private void removeNodeByKey(String key) {
            if(front == null)
                return;
            Node node = front;
            boolean found = false;
            while(node != null) {
                if(key.equals(node.key)) {
                    found = true;
                    break;
                }
                node = node.next;
            }
            if(found) {
                if(front == rear) {
                    front=rear=null;
                    return;
                }
                if(node == front) {
                    front = node.next;
                    front.prev = null;
                    return;
                }
                if(node == rear) {
                    rear = node.prev;
                    rear.next = null;
                    return;
                }
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }

        private void removeNodeFromRear() {
            if(rear == null) {
                return;
            }
            System.out.println("Delete a Key: " + rear.key);

            if(front == rear) {
                front = rear = null;
            } else {
                rear = rear.prev;
                rear.next = null;
            }
        }

        private String getRearKey() {
            return rear.key;
        }

        private void display() {
            if(front == null)
                System.out.println(" [] ");
            else {
                Node node = front;
                while (node != null ) {
                    System.out.print(" ("+node.key+","+node.value+") ");
                    node = node.next;
                }
                System.out.println();
            }
        }

    }
}
