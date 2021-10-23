import java.util.HashMap;
import java.util.HashSet;

/**
 * 141. 环形链表
 *
 * Floyd龟兔算法解决以下问题：
 *      ①检测是否有环
 *      ②环的起点节点
 *      ③环的长度
 *
 *
 * @author chen yu
 * @create 2021-10-23 16:23
 */
public class Solution141 {
    public static void main(String[] args) {

        //todo 没有构造输入

    }

    public static  ListNode detectCycle(ListNode head) {

        if(head==null||head.next==null){
            return null;
        }

        ListNode slow_node=head;
        ListNode fast_node=head;

        ListNode ptr_node=head;

        while(fast_node!=null&&fast_node.next!=null){
            slow_node=slow_node.next;
            fast_node=fast_node.next.next;
            if(slow_node==fast_node){
                break;
            }
        }

        if(fast_node!=null&&fast_node.next!=null){
            while(slow_node!=ptr_node){
                slow_node=slow_node.next;
                ptr_node=ptr_node.next;
            }
            return ptr_node;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
