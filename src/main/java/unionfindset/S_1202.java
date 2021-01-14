package unionfindset;

import org.junit.Test;

import java.util.*;

/**
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * <p>
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * <p>
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * <p>
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 */
public class S_1202 {
    /**
     * 如果索引中存在[a, b] 则可认为a和b是相互可达的，如果再有[b, c]则a,b,c是可达的。“可达”的意思是指在索引a, b, c上的字符
     * 可以任意交换。
     * 所以我们可以按照可达性将索引划分到不同的集合中，每个集合中的索引位置的字符按正序排序即可；
     * 集合划分可以考虑使用并查集
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.length() == 0 || pairs.size() == 0) {
            return s;
        }

        //集合划分
        UnionFind unionFind = new UnionFind(s.length());
        for (List<Integer> pair : pairs) {
            int i = pair.get(0);
            int j = pair.get(1);
            unionFind.union(i, j);
        }

        //这里我们可以使用有线队列实现排序，不用自己实现。如果想自己实现，可以使用链表+插入排序法
        Map<Integer, PriorityQueue<Character>> root2Chars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            root2Chars.computeIfAbsent(unionFind.find(i), c -> new PriorityQueue<>()).offer(s.charAt(i));
        }

        //构造结果字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int root = unionFind.find(i);
            sb.append(root2Chars.get(root).poll());
        }
        return sb.toString();
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int len) {
            parent = new int[len];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                //路径压缩
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }

        public void union(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);
            parent[root1] = root2;
        }
    }

    @Test
    public void test() {
        String s = "dabc";
        List<List<Integer>> pairs = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2));
        System.out.println(smallestStringWithSwaps(s, pairs));
    }
}
