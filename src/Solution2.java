import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 2. 两数相加
 */
public class Solution2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/2.txt");
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
        ListNode listNode = addTwoNumbers(dummyNode1.next, dummyNode2.next);

        System.out.println("相加后的结果");
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode=listNode.next;
        }


    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1_node = l1;
        ListNode l2_node = l2;
        ListNode end_l1=null ;
        ListNode end_l2=null;
        int len1 = 0;
        int len2 = 0;
        while (l1_node != null) {
            len1++;
            end_l1=l1_node;
            l1_node = l1_node.next;
        }
        while (l2_node != null) {
            len2++;
            end_l2=l2_node;
            l2_node = l2_node.next;
        }

        //补0
        if (len1 > len2) {
            int diff = len1 - len2;
            while (diff > 0) {
                diff--;
                end_l2.next = new ListNode(0);
                end_l2 = end_l2.next;
            }
        } else if (len2 > len1) {
            int diff = len2 - len1;
            while (diff > 0) {
                diff--;
                end_l1.next = new ListNode(0);
                end_l1 = end_l1.next;
            }
        }



        int cnt = Math.max(len1, len2);
        int sum = 0;
        int add = 0;
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode newNode = dummyNode;
        while (cnt > 0) {
            cnt--;
            sum = (node1.val + node2.val + add) % 10;
            add = (node1.val + node2.val + add) / 10;
            newNode.next = new ListNode(sum);
            newNode = newNode.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        if (add != 0) {
            newNode.next = new ListNode(add);
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


