package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class NodeUtil {
    public static ListNode string2ListNode(String nodeStr){
        JSONArray array = JSON.parseArray(nodeStr);
        if(array.isEmpty()) {
            return null;
        }
        ListNode node1 = new ListNode((Integer) array.get(0));
        ListNode tmp = node1;
        for (int i = 1; i < array.size(); i++) {
            tmp.next = new ListNode((Integer) array.get(i));
            tmp = tmp.next;
        }
        return node1;
    }
}
