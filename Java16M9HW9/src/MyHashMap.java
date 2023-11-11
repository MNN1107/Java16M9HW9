import java.util.Objects;

public class MyHashMap<K, V> {
    private Entry<K, V>[] buckets;
    private int size;
    public MyHashMap() {
        this.buckets = new Entry[10];
        size = 0;
    }
    public void put(K key, V value) {
        int hash = Math.abs(key.hashCode());
        int bucketNumber = hash % buckets.length;

        Entry<K, V> kvEntry = new Entry<>();
        kvEntry.setKey(key);
        kvEntry.setValue(value);

        if (buckets[bucketNumber] == null) {
            buckets[bucketNumber] = kvEntry;
        } else {
            kvEntry.setNextEntry(buckets[bucketNumber]);
            buckets[bucketNumber] = kvEntry;
        }
    }
    public void clear() {
        this.buckets = new Entry[10];
        size = 0;
    }
    public V get(K key) {
        int hash = Math.abs(key.hashCode());
        int bucketNumber = hash % buckets.length;

        Entry<K, V> currentEntry = buckets[bucketNumber];
        while (currentEntry.getNextEntry() != null) {
            V value = checkEquals(currentEntry, key);
            if (value != null)
                return value;
            currentEntry = currentEntry.getNextEntry();
        }
        return checkEquals(currentEntry, key);

    }
    private V checkEquals(Entry<K, V> e, K key) {
        if (e.getKey().equals(key)) {
            return e.getValue();
        }
        return null;
    }
    public int size() {
        int totalSize = 0;
        for (Entry<K, V> bucket : buckets) {
            Entry<K, V> currentEntry = bucket;
            while (currentEntry != null) {
                totalSize++;
                currentEntry = currentEntry.getNextEntry();
            }
        }
        return totalSize;
    }

    public void remove(K key) {
        int hash = Math.abs(key.hashCode());
        int bucketNumber = hash % buckets.length;

        Entry<K, V> currentEntry = buckets[bucketNumber];
        Entry<K, V> prevEntry = null;

        while (currentEntry != null) {
            if (Objects.equals(currentEntry.getKey(), key)) {
                if (prevEntry == null) {
                    buckets[bucketNumber] = currentEntry.getNextEntry();
                } else {
                    prevEntry.setNextEntry(currentEntry.getNextEntry());
                }
                size--;
                return;
            }
            prevEntry = currentEntry;
            currentEntry = currentEntry.getNextEntry();
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Entry<K, V> bucket : buckets) {
            Entry<K, V> currentEntry = bucket;
            while (currentEntry != null) {
                result.append(currentEntry.getKey() + " = " + currentEntry.getValue() + " ");
                currentEntry = currentEntry.getNextEntry();
            }
        }
        return result.toString();
    }
}
