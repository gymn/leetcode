package medium.linktable;

import org.junit.Test;
import util.ListNode;
import util.Node;
import util.NodeUtil;
import util.ShowUtils;

import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class S_002 {
    /**
     * 解法一：
     * 使用两个指针分别指向l1和l2，按位相加，超过10进位即可，需要注意的是在相加结束后，判断一下进位标识
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = head;
        int flag = 0; // 进位标识
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + flag;
            flag = sum / 10;
            p3.next = new ListNode(sum % 10);
            p1 = p1.next;
            p2 = p2.next;
            p3 = p3.next;
        }

        while (p1 != null) {
            int sum = p1.val + flag;
            flag = sum / 10;
            p3.next = new ListNode(sum % 10);
            p3 = p3.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int sum = p2.val + flag;
            flag = sum / 10;
            p3.next = new ListNode(sum % 10);
            p3 = p3.next;
            p2 = p2.next;
        }

        if (flag == 1) {
            p3.next = new ListNode(1);
        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode l1 = NodeUtil.string2ListNode("[9,9,9]");
        ListNode l2 = NodeUtil.string2ListNode("[9,9,9,9,9,9]");
        System.out.println(addTwoNumbers(l1, l2));
    }
}
