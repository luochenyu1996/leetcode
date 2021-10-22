import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 445. 两数相加 II
 *
 * @author chen yu
 */

public class Solution445 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input/445.txt");
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

        while (listNode!=null){
            System.out.print(listNode.val);
            listNode=listNode.next;
        }


    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();

        //对两个链表进行入栈  并且统计长度
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null) {
            stack1.push(node1.val);
            node1 = node1.next;
        }
        while (node2 != null) {
            stack2.push(node2.val);
            node2 = node2.next;
        }

        //进位值
        int carr = 0;
        //和(取余)
        int sum = 0;

        ListNode res= null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carr != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            sum = (a + b + carr) % 10;
            carr = (a + b + carr) / 10;
            ListNode curNode = new ListNode(sum);
           //这里关键
            curNode.next=res;
            res=curNode;
        }
        return res;

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
