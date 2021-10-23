import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 725. 分隔链表
 *
 * @author chen yu
 * @create 2021-10-22 10:21
 */
public class Solution86 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input/86.txt");
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
        ListNode listNode = partition(dummyNode1.next,3);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }

    }
    public static ListNode partition(ListNode head, int x) {

        ListNode bigDummy=new ListNode(-1);
        ListNode node_big=bigDummy;

        ListNode smallDummy=new ListNode(-1);
        ListNode node_small=smallDummy;

        ListNode node = head;

        while (node!=null){
            if (node.val<x){
                node_small.next=node;
                node_small=node_small.next;
                node=node.next;
            }else {
                node_big.next=node;
                node_big=node_big.next;
                node=node.next;
            }
        }
        node_big.next=null;
        node_small.next=bigDummy.next;
        return  smallDummy.next;

    }


    static public class ListNode {
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
