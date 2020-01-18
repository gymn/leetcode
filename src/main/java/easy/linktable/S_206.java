package easy.linktable;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hunan
 * @date 2020-01-17
 * @time 12:49
 */
public class S_206 {
    /**
     * 递归思路
     * 需要一个额外的头结点记录反转后的链表第一个节点
     * 反转后需要将原头结点next置为null
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode h = new ListNode(0);

        ListNode node = reverse(head, h);
        node.next = null;
        return h.next;
    }

    private ListNode reverse(ListNode head, ListNode newHead) {
        if (head.next == null) {
            newHead.next = head;
            return head;
        } else {
            ListNode node = reverse(head.next, newHead);
            node.next = head;
            return head;
        }
    }

    /**
     * 迭代思路
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode p1 = null, p2 = head;

        while (p2 != null) {
            ListNode p3 = p2.next;
            p2.next = p1;

            p1 = p2;
            p2 = p3;
        }
        return p1;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode p1 = head;
        while (p1 != null) {
            list.add(p1);
            p1 = p1.next;
        }

        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(0).next = null;
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 2; i <= 5; i++) {
            ListNode newNode = new ListNode(i);
            tmp.next = newNode;
            tmp = newNode;
        }
        System.out.println(head);

        ListNode rev = new S_206().reverseList3(head);
        System.out.println(rev);
    }
}
