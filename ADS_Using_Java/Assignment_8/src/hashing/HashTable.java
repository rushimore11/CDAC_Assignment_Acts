package hashing;

public class HashTable {
    private LinkedList[] buckets;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
       
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList();
        }
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(String key, int value) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].put(key, value);
    }

    public Integer get(String key) {
        int bucketIndex = hash(key);
        return buckets[bucketIndex].get(key);
    }

    public boolean remove(String key) {
        int bucketIndex = hash(key);
        return buckets[bucketIndex].remove(key);
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            buckets[i].printList();
            System.out.println();
        }
    }
}
