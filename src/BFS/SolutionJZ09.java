package BFS;

import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * @author chen yu
 * @create 2022-02-28 20:08
 */
public class SolutionJZ09 {


    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public SolutionJZ09() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            return -1;
        }
    }

}


