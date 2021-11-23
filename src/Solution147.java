/**
 * 147. 对链表进行插入排序
 *
 * @author chen yu
 * @create 2021-11-23 12:04
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null){
            return head;
        }

        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next=head;
        ListNode begin=dummyNode;
        ListNode end=head;
        ListNode curr=head.next;

        while (curr!=null){
            if(end.val<=curr.val){
                end=end.next;
            }else{
                //插入

                while(begin.next.val<=curr.val){
                    begin=begin.next;
                }
                end.next=curr.next;
                curr.next=begin.next;
                begin.next=curr;
                begin=dummyNode;

            }
            curr=end.next;
        }
        return  dummyNode.next;

    }




      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
