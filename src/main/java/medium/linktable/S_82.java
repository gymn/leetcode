package medium.linktable;

import util.ListNode;

/**
 * @author hunan
 * @date 2020-01-17
 * @time 15:25
 */
public class S_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode prev = node;
        ListNode cur = head;
        boolean flag = false;

        while (cur != null) {
            ListNode tmp = cur.next;
            while (tmp != null && cur.val == tmp.val) {
                prev.next = tmp.next;
                tmp = tmp.next;
                flag = true;
            }
            if (!flag) {
                prev = prev.next;
            }
            flag = false;
            cur = prev.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.from(new int[]{1, 2, 3, 3, 4, 4, 5});
        new S_82().deleteDuplicates(head);
        System.out.println(head);
    }
}
