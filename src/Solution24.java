/**
 * 24.两两交换链表中的节点
 *
 * @author chen yu
 * @create 2021-11-23 11:49
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {

            if(head==null||head.next==null){
                return head;
            }
            ListNode node=head.next.next;
            ListNode headNode=head.next;
            head.next.next=head;
            head.next=swapPairs(node);
            return  headNode;

        }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    }







