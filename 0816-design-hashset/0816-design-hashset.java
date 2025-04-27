class MyHashSet {
    // Array size for the HashSet
    private static final int SIZE = 1000;
    
    // Array of linked lists (buckets)
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        // Initialize the buckets array
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    // Hash function to map key to an index
    private int hash(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    // Add a key to the HashSet
    public void add(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        // Avoid adding duplicate keys
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    // Check if the key is in the HashSet
    public boolean contains(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        return bucket.contains(key);
    }
    
    // Remove a key from the HashSet
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        bucket.remove(Integer.valueOf(key)); // Removes the first occurrence of key
    }
}
