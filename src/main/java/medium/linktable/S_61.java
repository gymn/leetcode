package medium.linktable;

import util.ListNode;

/**
 * @author hunan
 * @date 2020-01-17
 * @time 14:44
 */
public class S_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        int len = 1;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        p.next = head;
        int step = len - k % len - 1;

        ListNode tmp = head;
        while (step > 0) {
            tmp = tmp.next;
            step--;
        }

        head = tmp.next;
        tmp.next = null;
        return head;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ListNode head = ListNode.range(1, 5);
            ListNode rev = new S_61().rotateRight(head, i);
            System.out.println(rev);
        }
    }
}
