package easy.linktable;

import util.ListNode;

/**
 * @Author hunan
 * @Date 2018/6/19
 * @Time 下午11:16
 */
public class S_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1!=null){
            while (p2!=null){
                if(p1==p2){
                    return p1;
                }else{
                }
            }
        }
    }
}
