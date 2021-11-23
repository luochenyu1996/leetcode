import java.util.*;

/**
 * 146. LRU 缓存机制
 * @author chen yu
 * @create 2021-10-26 11:19
 */
public class Solution146 {

    //最大容量
    private final int capacity;

    private final HashMap<Integer,Node> map;

    //使用的链表
    private final MyDeque queue;


    //构造函数
    public Solution146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        queue = new MyDeque();
    }

    public  int  get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node useNode = map.get(key);
        put(key,useNode.value);
        return useNode.value;
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            queue.remove(map.get(key));
            //对旧的值进行更新
            queue.addFirst(x);
            map.put(key, x);
        } else {
            if (capacity == queue.size) {

                Node lastNode = queue.removeLast();
                map.remove(lastNode.key);
            }
            queue.addFirst(x);
            map.put(key, x);
        }
    }

    class Node {
        public int key, value;
        public Node next, prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class MyDeque {
        private Node head;
        private Node tail;
        private int size;
        public void addFirst(Node node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next=head;
                head.prev=node;
                head=head.prev;
            }
            size++;
        }
        public void remove(Node node) {
            if (head == node && tail == node) {
                head = null;
                tail = null;
            } else if (tail == node) {
                tail=tail.prev;
                tail.next.prev=null;
                tail.next=null;
            } else if (head == node) {
                head=head.next;
                head.prev.next=null;
                head.prev=null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next=null;
                node.prev=null;
            }
            size--;
        }
        public Node removeLast() {
            Node node = tail;
            remove(tail);
            return node;
        }
        public int size() {
            return size;
        }
    }


}


