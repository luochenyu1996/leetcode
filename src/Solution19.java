import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 19.删除链表的倒数第 N 个结点
 */

public class Solution19 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/19.txt");
        Scanner scanner = new Scanner(file);
        LinkedList<String> strings = new LinkedList<>();
        while (scanner.hasNext()) {
            String in = scanner.nextLine();
            strings.add(in);
        }
        //转换为链表
        String[] nums = strings.get(0).split(" ");
        ListNode head = new ListNode(Integer.parseInt(nums[0]));
        ListNode curNode = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(Integer.parseInt(nums[i]));
            curNode.next = node;
            curNode = curNode.next;
        }
        System.out.println("转换前的链表");
        ListNode node = head;

        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();


        ListNode ans = removeNthFromEnd(head, Integer.parseInt(strings.get(1)));

        System.out.println("转换后的链表");
        while (ans != null) {
            System.out.print(ans.val);
            ans = ans.next;
        }


    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 先获得链表的长度
        int len = getLenOfNode(head);

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        // 从虚拟头结点开始走 len - n 步
        for (int i = 0; i < len - n; i++) {
            curNode = curNode.next;
        }

        // 删除结点，先声明待删除结点
        ListNode deleteNode = curNode.next;
        // 再修改指针指向
        curNode.next = deleteNode.next;
        // 删除结点的 next 指针释放引用
        deleteNode.next = null;
        return dummyNode.next;
    }


    private static int getLenOfNode(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
