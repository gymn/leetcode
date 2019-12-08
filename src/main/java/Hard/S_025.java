package Hard;

import org.junit.Test;
import util.ListNode;

public class S_025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ph = new ListNode(0);
        ph.next = head;
        if (k < 2) {
            return head;
        }
        swap(ph, k);
        return ph.next;
    }

    private void swap(ListNode listNode, int k) {
        ListNode[] cache = new ListNode[k];
        ListNode tmp = listNode.next;
        int i = 0;
        for (; i < k && tmp != null; i++) {
            cache[i] = tmp;
            tmp = tmp.next;
        }
        if (i != k) {
            return;
        }

        ListNode last = cache[k - 1].next;
        int start = 0, end = k - 1;
        while (start < end) {
            ListNode p1 = cache[start];
            cache[start] = cache[end];
            cache[end] = p1;
            start++;
            end--;
        }
        listNode.next = cache[0];
        for (int j = 0; j < cache.length - 1; j++) {
            cache[j].next = cache[j + 1];
        }
        cache[k - 1].next = last;
        swap(cache[k - 1], k);
    }

    @Test
    public void test01() {
        ListNode node1 = new ListNode(1);
        ListNode tmp = node1;
        for (int i = 2; i < 6; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        System.out.println(reverseKGroup(node1, 2));
    }
}
