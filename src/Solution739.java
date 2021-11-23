import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 739. 每日温度
 *
 * 维持一个单调减的数列
 * @author chen yu
 * @create 2021-10-29 10:40
 */
public class Solution739 {
    public static void main(String[] args) {
        int[]  temperatures={73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temperatures);
        for (int re : res) {
            System.out.print(re);
        }


    }
    public static int[] dailyTemperatures(int[] temperatures) {
        //使用数组下标进行入栈
            ArrayDeque<Integer>  stack= new ArrayDeque<Integer>();
            int len=temperatures.length;
            int[] ans= new int[len];
            for(int i=0;i<len;i++){
                while(!stack.isEmpty()&& temperatures[i]>temperatures[stack.peek()]){
                    int out= stack.pop();
                    ans[out]=i-out;
                }
                stack.push(i);
            }
            return ans;

        }
}
