package org.pg4200.ex06;

import org.pg4200.les06.hash.MyHashMap;

import java.lang.reflect.Array;

public class HashMapLinearProbe<K, V> implements MyHashMap<K, V> {

    private final int M = 997;

    private class Entry {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] data = (Entry[]) Array.newInstance(Entry.class, M);

    private int size = 0;

    @Override
    public void put(K key, V value) {

        int i = index(key);

        int position = findKey(i, key);
        if (position < i) {
            position = findEmpty(i);
        }

        if (position < 0) {
            throw new IllegalArgumentException("Map is full");
        }

        if (data[position] == null) {
            data[position] = new Entry(key, value);
            size++;
        } else {
            Entry entry = data[position];
            entry.key = key;
            entry.value = value;
        }
    }

    private boolean isMissing(int i) {
        return i >= data.length || data[i] == null || data[i].key == null;
    }

    private boolean isPresentButNotMatching(int i, K key) {
        return i < data.length && data[i] != null && !key.equals(data[i].key);
    }

    private int findEmpty(int i) {
        int k = i;

        while (!isMissing(k) && k < data.length) {
            k++;
        }

        if (k < data.length) {
            assert isMissing(k);
            return k;
        }

        k = 0;
        while (!isMissing(k) && k < i) {
            k++;
        }

        if (k < i) {
            return k;
        } else {
            return -1;
        }
    }

    private int findKey(int i, K key) {

        int k = i;

        while (isPresentButNotMatching(k, key) && k < data.length) {
            k++;
        }

        if (k < data.length) {
            if (data[k] == null) {
                return -1;
            }
            assert key.equals(data[k].key);
            return k;
        }

        k = 0;
        while (isPresentButNotMatching(k, key) && k < i) {
            k++;
        }

        if (k < i && data[k] != null) {
            assert key.equals(data[k].key);
            return k;
        } else {
            return -1;
        }
    }

    private int index(K key) {

        int positiveHash = key.hashCode() & 0x7f_ff_ff_ff;

        return positiveHash % M;
    }

    @Override
    public void delete(K key) {
        int i = index(key);

        int position = findKey(i, key);

        if (position < 0) return;

        Entry entry = data[position];
        if (entry != null) {
            entry.key = null;
            entry.value = null;
            size--;
        }
    }

    @Override
    public V get(K key) {
        int i = index(key);

        int position = findKey(i, key);
        if (position >= 0 && !isMissing(position)) {
            return data[position].value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
