import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 876. 链表的中间结点 乔巧妙的方法是利用双指针
 *
 * @author chen yu
 * @create 2021-10-22 11:26
 */
public class Solution876 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/876.txt");
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
        ListNode listNode = middleNode(dummyNode1.next);

        System.out.println(listNode.val);
    }


    public static ListNode middleNode(ListNode head) {
        ListNode fast_node=head;
        ListNode slow_node=head;

        while (fast_node!=null&&fast_node.next!=null){
             fast_node=fast_node.next.next;
             slow_node=slow_node.next;
        }

        return slow_node;




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
