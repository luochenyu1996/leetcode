import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * 方法1:使用分治的方法
 * 方法2:贪心，优先队列
 *
 * @author chen yu
 * @create 2021-10-21 10:41
 */
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        //使用一个有限队列
       PriorityQueue<ListNode> queue=  new PriorityQueue<ListNode>(len, Comparator.comparingInt(a -> a.val));
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode=dummyNode;
        //取每个链表的头加入到优先队列中
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            //出队
            ListNode poll_node = queue.poll();
            curNode.next=poll_node;
            curNode=curNode.next;

            //当前节点的下一个节点入队
            if (curNode.next != null) {
                // 只有非空节点才能加入到优先队列中
                queue.add(curNode.next);
            }
        }

        return dummyNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
