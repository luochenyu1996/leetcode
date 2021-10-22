import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @author chen yu
 * @create 2021-10-21 11:46
 */
public class Solution82 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/82.txt");
        Scanner scanner = new Scanner(file);
        String str = null;
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();

        }
        String[] s1 = str.split(" ");
        ListNode dummyNode1 = new ListNode(-1);
        ListNode node1 = dummyNode1;

        for (int i = 0; i < s1.length; i++) {
            node1.next = new ListNode(Integer.parseInt(s1[i]));
            node1 = node1.next;
        }
        ListNode listNode = deleteDuplicates(dummyNode1.next);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow_node = dummyNode;
        ListNode fast_node = head;
        while (fast_node!=null&&fast_node.next!= null) {
            if (fast_node.next.val == slow_node.next.val) {
                while (fast_node.next!=null&&slow_node.next.val==fast_node.next.val ) {
                    fast_node = fast_node.next;
                }
                slow_node.next=fast_node.next;
                ListNode temp_node= fast_node;
                fast_node=fast_node.next;
                temp_node.next=null;
                continue;
            }
                slow_node = slow_node.next;
                fast_node = fast_node.next;

        }
        return dummyNode.next;
    }

    static class ListNode {
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






