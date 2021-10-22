import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @author chen yu
 * @create 2021-10-22 09:58
 */
public class Solution83 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/83.txt");
        Scanner scanner = new Scanner(file);
        String str = null;
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
        }
        String[] s1 = str.split(" ");
        ListNode dummyNode1 = new ListNode(-1);
        ListNode node1 = dummyNode1;

        for (String s : s1) {
            node1.next = new ListNode(Integer.parseInt(s));
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
        ListNode slow_node = head;
        ListNode fast_node = slow_node.next;
        while (fast_node != null) {
            if (fast_node.val == slow_node.val) {
                while (fast_node != null && fast_node.val == slow_node.val) {
                    fast_node = fast_node.next;
                }
                slow_node.next = fast_node;
            } else {
                fast_node = fast_node.next;
                slow_node = slow_node.next;
            }
        }
        return head;
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
