package medium.linktable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制
 */
public class S_146 {
    @Test
    public void test() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}

class LRUCache {
    private Map<Integer, Entry> index;
    private Entry head;
    private Entry tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        index = new HashMap<>(capacity);
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;
        size=0;
    }

    public int get(int key) {
        Entry entry = index.get(key);
        if (entry != null) {
            refresh(entry);
            return entry.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Entry entry = index.get(key);
        if (entry != null) {
            entry.value = value;
            refresh(entry);
        } else {
            if (size >= capacity) {
                index.remove(tail.pre.key);
                remove(tail.pre);
                size--;
            }

            Entry newEntry = new Entry(key, value);
            newEntry.next = head.next;
            head.next.pre = newEntry;
            head.next = newEntry;
            newEntry.pre = head;

            index.put(key,newEntry);
            size++;
        }
    }

    private void remove(Entry entry) {
        entry.pre.next = entry.next;
        entry.next.pre = entry.pre;
    }

    private void refresh(Entry entry) {
        if (entry.pre == head) {
            return;
        }
        entry.pre.next = entry.next;
        entry.next.pre = entry.pre;

        entry.next = head.next;
        head.next.pre = entry;
        head.next = entry;
        entry.pre = head;
    }

    private static class Entry {
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Entry() {
        }

        int key;
        int value;
        Entry pre;
        Entry next;
    }
}