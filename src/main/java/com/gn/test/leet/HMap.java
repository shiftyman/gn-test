package com.gn.test.leet;

public class HMap<K, V> {

    private class Entry<K, V> {
        private K k;
        private V v;
        private Entry next;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    private int size = 0;
    private int cap = 16;
    private double growFactor = 0.75;
    private Entry[] entries;

    public HMap() {
        entries = new Entry[cap];
    }

    public V put(K key, V value) {
        ensureCapacity();

        int index = calculateIndex(key);
        if (entries[index] != null) {
            Entry pos = entries[index];
            while (true) {
                if (pos.k.equals(key)) {
                    V old = (V) pos.v;
                    pos.v = value;
                    return old;
                }
                if (pos.next == null)
                    break;
                pos = pos.next;
            }
            pos.next = new Entry<>(key, value);
        } else {
            entries[index] = new Entry<>(key, value);
        }
        size++;

        return null;
    }

    public V get(K key) {
        int index = calculateIndex(key);
        Entry entry = entries[index];
        while(entry != null) {
            if (entry.k.equals(key)) {
                return (V) entry.v;
            }
            entry = entry.next;
        }

        return null;
    }

    private int calculateIndex(K key) {
        return key.hashCode() & (cap - 1);
    }

    private void ensureCapacity() {
        if (size + 1 > cap * growFactor) {
            Entry[] newEntries = new Entry[cap << 1];
            System.arraycopy(entries, 0, newEntries, 0, cap);
            entries = newEntries;
            cap = newEntries.length;
        }
    }

    public static void main(String[] args) {
        HMap<Integer, Integer> map = new HMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put(i, i);
        }
        for (int i = 0; i < 1000; i++) {
            map.put(i*2, i+1);
        }
        System.out.println(map.cap);
        System.out.println(map.size);
        for (int i = 0; i < 50; i++) {
            System.out.println(map.get(i));
        }

    }
}
