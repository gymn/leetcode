package medium;

import util.ListNode;

public class S_024 {
    public ListNode swapPairs(ListNode head) {
        ListNode ph = new ListNode(0);
        ph.next = head;
        swap(ph);
        return ph.next;
    }

    private void swap(ListNode listNode) {
        if (listNode.next == null || listNode.next.next == null) {
            return;
        }
        ListNode tmp = listNode.next;
        listNode.next = tmp.next;
        tmp.next = listNode.next.next;
        listNode.next.next = tmp;
        swap(tmp);
    }
}
