package easy.linktable;

import util.ListNode;

/**
 * @Author hunan
 * @Date 2018/6/19
 * @Time 下午11:16
 */
public class S_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        int count1 = 0;
        while (p1.next != null) {
            p1 = p1.next;
            count1++;
        }

        ListNode p2 = headB;
        int count2 = 0;
        while (p2.next != null) {
            p2 = p2.next;
            count2++;
        }

        if (!p1.equals(p2)) {
            return null;
        }

        int len = Math.abs(count1 - count2);
        p1 = headA;
        p2 = headB;

        if (count1 > count2) {
            for (int i = 0; i < len; i++) {
                p1 = p1.next;
            }
        }

        if (count1 < count2) {
            for (int j = 0; j < len; j++) {
                p2 = p2.next;
            }
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
