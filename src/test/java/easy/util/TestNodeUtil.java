package easy.util;

import org.junit.Test;
import util.ListNode;
import util.NodeUtil;

public class TestNodeUtil {
    @Test
    public void testParseNode() {
        ListNode node = NodeUtil.string2ListNode("[1,2,3,4,5]");
        System.out.println(node);
    }
}
