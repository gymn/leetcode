package medium.linktable;

import util.ListNode;

/**
 * @author hunan
 * @date 2020-01-17
 * @time 13:39
 */
public class S_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode p1 = null, p2 = head;
        while (m > 1) {
            p1 = p2;
            p2 = p2.next;
            m--;
            n--;
        }

        ListNode con = p1, tail = p2;

        while (n > 0) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
            n--;
        }

        if (con == null) {
            head = p1;
        } else {
            con.next = p1;
        }
        tail.next = p2;

        return head;
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

        ListNode rev = new S_92().reverseBetween(head, 2, 4);
        System.out.println(rev);
    }
}
