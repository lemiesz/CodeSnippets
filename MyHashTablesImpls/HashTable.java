import java.lang.reflect.Array;

import org.omg.CosNaming.NameHolder;

public class HashTable<K, V> {

    private static int INITIAL_SIZE = 100;

    private Node[] values;
    private int currentNumberOfItems;
    private int tableSize;

    HashTable() {
        this.values = new Node[INITIAL_SIZE];
        this.currentNumberOfItems = 0;
        this.tableSize = INITIAL_SIZE;
    }

    //insert 
    public void insert(K key, V value) {
        int hashCode = (this.hash(Math.abs(key.hashCode())));
        final Node head = this.values[hashCode];
        if (head == null) {
            this.values[hashCode] = new Node(value, key, null);
        } else {
            final Node valueNode = Node.findNode(head, key);
            // if value alread exists then update node with that value
            if (valueNode != null) {
                valueNode.value = value;
                return;
            }
            final Node tail = Node.findTail(head);
            tail.nextNode = new Node(value, key,  null);
        }
    }

    public V find(K key) {
        final Node head = this.values[hash(Math.abs(key.hashCode()))];
        final Node valueNode = Node.findNode(head, key);
        return valueNode != null ? (V) valueNode.value : null;
    }

    public V delete(K key) {
        Node currentNode = this.values[hash(Math.abs(key.hashCode()))];
        if(currentNode.nextNode == null) {
            this.values[hash(Math.abs(key.hashCode()))] = null;
            return null;
        }
        Node prevNode = null;
        while(currentNode != null) {
            if(currentNode.key.equals(key)) {
                if(prevNode != null) {
                    prevNode.nextNode = currentNode.nextNode;
                }
                return (V) currentNode.value;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    private int hash(int prehash) {
        return prehash % this.tableSize;
    }

    public static class Node {
        public Object value;
        public Object key;
        public Node nextNode;

        Node(Object value, Object key, Node next) {
            this.value = value;
            this.key = key;
            this.nextNode = next;
        }

        public static Node findTail(Node node) {
            Node currentNode = node;
            while (currentNode != null && currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            return currentNode;
        }

        public static Node findNode(Node startNode, Object key) {
            Node currentNode = startNode;
            while (currentNode != null) {
                if(currentNode.key.equals(key)) {
                    break;
                }
                currentNode = currentNode.nextNode;
            }
            return currentNode;
        }
    }

}