package easy.linktable;

import util.ListNode;

/**
 * @Author hunan
 * @Date 2018/6/11
 * @Time 下午11:29
 * 给定一个链表，判断链表中是否有环。
 */
public class S_141 {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do{
            slow = slow.next;
            if(fast.next==null||fast.next.next==null){
                return false;
            }
            fast = fast.next.next;
        } while(!slow.equals(fast));
        return true;
    }
}
