package easy;

/**
 * Author:hunan07(hunan07@meituan.com)
 * Date:2018/5/7
 */

import util.ListNode;

/**
 * 删除排序链表中的重复元素
 */
public class S_083 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode p1 = head, p2 = head.next;
        while(p1.next!=null){
            if(p2.val==p1.val){
                p1.next = p2.next;
                p2 = p1.next;
            }else{
                p1 = p2;
                p2 = p2.next;
            }
        }
        return head;
    }
}
