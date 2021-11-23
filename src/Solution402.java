import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉 K 位数字
 *
 * @author chen yu
 * @create 2021-10-28 09:34
 */
public class Solution402 {

    public static void main(String[] args) {
        String str = "1234567890";
        String s = removeKdigits(str, 9);
        System.out.println(s);
    }

    public static String removeKdigits(String num, int k) {
        ArrayDeque<Character> stack= new ArrayDeque<Character>();
        int len=num.length();
        for(int i=0;i<len;i++){
            //有小的数字需要一直往前走
            while(!stack.isEmpty()&&k>0&&num.charAt(i)<stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        for(int i=0;i<k;i++){
            stack.pop();
        }

        //需要去掉开头的0

        StringBuffer stringBuffer = new StringBuffer();
        boolean flag=true;
        while (!stack.isEmpty()){
            Character last = stack.removeLast();
            if(flag&&last=='0'){
                continue;
            }
            flag=false;
            stringBuffer.append(last);
        }
        return   stringBuffer.length()==0?"0":stringBuffer.toString();
    }


}

