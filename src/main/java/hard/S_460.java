package hard;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * 实现 LFUCache 类
 */
public class S_460 {
    @Test
    public void test() {
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1);
        lFUCache.put(2, 2);
        lFUCache.get(1);      // 返回 1
        lFUCache.put(3, 3);   // 去除键 2
        lFUCache.get(2);      // 返回 -1（未找到）
        lFUCache.get(3);      // 返回 3
        lFUCache.put(4, 4);   // 去除键 1
        lFUCache.get(1);      // 返回 -1（未找到）
        lFUCache.get(3);      // 返回 3
        lFUCache.get(4);      // 返回 4
    }

    class LFUCache {
        private Map<Integer, Entry> index;
        private Entry head;
        private Entry tail;
        private int capacity;
        private int size;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            index = new HashMap<>(capacity);
            head = new Entry();
            tail = new Entry();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Entry entry = index.get(key);
            if (entry != null) {
                entry.frequency++;
                adjust(entry);
                return entry.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            Entry entry = index.get(key);
            if (entry != null) {
                entry.value = value;
                entry.frequency++;
                adjust(entry);
            } else if (capacity > 0) {
                if (size == capacity) {
                    index.remove(tail.pre.key);
                    remove(tail.pre);
                    size--;
                }

                Entry entry1 = new Entry(key, value);
                entry1.pre = tail.pre;
                tail.pre.next = entry1;
                entry1.next = tail;
                tail.pre = entry1;
                adjust(entry1);
                index.put(key, entry1);
                size++;
            }
        }

        private void adjust(Entry entry) {
            while (entry.pre != head && entry.frequency >= entry.pre.frequency) {
                entry.pre.next = entry.next;
                entry.next.pre = entry.pre;

                Entry p0 = entry.pre.pre;
                Entry p2 = entry.pre;
                p0.next = entry;
                entry.pre = p0;
                entry.next = p2;
                p2.pre = entry;
            }
        }

        private void remove(Entry entry) {
            entry.pre.next = entry.next;
            entry.next.pre = entry.pre;
        }
    }

    class Entry {
        Entry() {

        }

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }

        int key;
        int value;
        int frequency;
        Entry pre;
        Entry next;
    }
}