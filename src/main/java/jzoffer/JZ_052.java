package jzoffer;

import org.junit.Test;
import util.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class JZ_052 {
    /**
     * 解法一：
     * 对于ListA中的每个节点，尝试在ListB中找出相同节点，第一个找到的即为第一个公共节点
     * 时间复杂度O(mn) m和n分别为两个链表的长度
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        while (p1 != null) {
            ListNode p2 = headB;
            while (p2 != null) {
                if (p1 == p2) {
                    return p1;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return null;
    }

    /**
     * 解法二：
     * 如果这是一个双向链表，我们可以从尾部向前同时遍历两个链表，当遇到第一个不相等的节点时，其后节点即为第一个公共节点
     * 对于单链表，公共节点前的长度是不一样的，我们需要抹平这个差距，可以分别算出两个链表的长度，较长的链表先走几步即可
     * 可以利用快慢指针实现
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int len1 = 0;
        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }

        int len2 = 0;
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }

        p1 = headA;
        p2 = headB;
        if (len1 > len2) {
            int d = len1 - len2;
            while (d > 0) {
                p1 = p1.next;
                d--;
            }
        }

        if (len1 < len2) {
            int d = len2 - len1;
            while (d > 0) {
                p2 = p2.next;
                d--;
            }
        }

        while (p1 != p2 && p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
