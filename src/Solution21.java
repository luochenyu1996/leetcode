import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 21. 合并两个有序链表
 *
 * @author chen yu
 * @create 2021-10-21 10:06
 */
public class Solution21 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input/21.txt");
        Scanner scanner = new Scanner(file);
        LinkedList<String> strings = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            strings.add(str);
        }
        String[] s1 = strings.get(0).split(" ");
        String[] s2 = strings.get(1).split(" ");

        ListNode dummyNode1 = new ListNode(-1);
       ListNode node1 = dummyNode1;
        ListNode dummyNode2 = new ListNode(-1);
        ListNode node2 = dummyNode2;
        for (int i = 0; i < s1.length; i++) {
            node1.next = new ListNode(Integer.parseInt(s1[i]));
            node1 = node1.next;
        }
        for (int i = 0; i < s2.length; i++) {
            node2.next = new ListNode(Integer.parseInt(s2[i]));
            node2 = node2.next;
        }

        ListNode listNode = mergeTwoLists(dummyNode1.next, dummyNode2.next);

        while (listNode!=null){
            System.out.print(listNode.val+" ");
            listNode=listNode.next;
        }

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);

        ListNode node0 = dummyNode;

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode curNode = null;

        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                curNode = new ListNode(node2.val);
                node0.next = curNode;
                node0 = node0.next;
                node2 = node2.next;
            } else if (node1.val < node2.val) {
                curNode = new ListNode(node1.val);
                node0.next = curNode;
                node0 = node0.next;
                node1 = node1.next;
            } else {
                curNode = new ListNode(node1.val);
                node0.next = curNode;
                node0 = node0.next;
                node1 = node1.next;
                curNode = new ListNode(node2.val);
                node0.next = curNode;
                node0 = node0.next;
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            node0.next = node1;
        }
        if (node2 != null) {
            node0.next = node2;
        }
        return dummyNode.next;
    }


    static class  ListNode {
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
