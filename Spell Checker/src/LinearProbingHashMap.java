

public class LinearProbingHashMap<Key> {
    private static final int INITIAL_CAPACITY = 200000;

    private Key[] keys;
    private int capacity;
    private int size;

    public LinearProbingHashMap() {
        this(INITIAL_CAPACITY);
    }

    public LinearProbingHashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keys = (Key[]) new Object[capacity];
    }

    private int hash(Key key) {
        return Math.abs(key.hashCode() % capacity);
    }



    public boolean search(Key key) {
        int index = hash(key);
        int startIndex = index;

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return true;
            }

            if (index + 1 == startIndex) {
                return false; // start
            }

            index = (index + 1) % capacity; // cycle through
        }

        return false;
    }
    public void insert(Key key) {
        if (size >= capacity) {
            resize(2 * capacity);
        }

        int index = hash(key);

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                // Key already exists, do nothing or update as needed
                return;
            }


            index = (index + 1) % capacity; // cycle through
        }

        // Reaching here means the slot is empty
        keys[index] = key;
        size++;
    }
    private void resize(int newCapacity) {
        LinearProbingHashMap<Key> newHashMap = new LinearProbingHashMap<>(newCapacity);

        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                newHashMap.insert(keys[i]);
            }
        }

        this.keys = newHashMap.keys;
        this.capacity = newCapacity;
    }
    public void delete(Key key) {
        int index = hash(key);
        int startIndex = index;

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                // Delete the key
                keys[index] = null;
                size--;

                // Rehash the remaining keys in the cluster
                index = (index + 1) % capacity;
                while (keys[index] != null) {
                    keys[index] = null;
                    size--;
                    index = (index + 1) % capacity;
                }

                return;
            }

            if (index + 1 == startIndex) {
                return; // Key not found
            }

            index = (index + 1) % capacity; // cycle through
        }

    }

}