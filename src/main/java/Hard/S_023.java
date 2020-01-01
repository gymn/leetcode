package Hard;

import util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S_023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (ListNode listNode : lists) {
            ListNode p = listNode;
            while (p != null) {
                list.add(p.val);
                p = p.next;
            }
        }
        if (list.size() == 0) {
            return null;
        }
        Collections.sort(list);
        ListNode head = new ListNode(list.get(0));
        ListNode p1 = head;
        for (int i = 1; i < list.size(); i++) {
            p1.next = new ListNode(list.get(i));
            p1 = p1.next;
        }
        return head;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode[] pa = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            pa[i] = lists[i];
        }

        ListNode head = new ListNode(0);
        ListNode p = head;
        int flag = 1;
        while (flag == 1) {
            flag = 0;
            int minVal = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < pa.length; i++) {
                if (pa[i] != null && pa[i].val < minVal) {
                    minVal = pa[i].val;
                    minIndex = i;
                    flag = 1;
                }
            }

            if (minIndex >= 0) {
                p.next = new ListNode(minVal);
                p = p.next;
                pa[minIndex] =pa[minIndex].next;
            }
        }
        return head.next;
    }
}
