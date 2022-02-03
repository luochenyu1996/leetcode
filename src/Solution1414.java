import java.util.ArrayList;

/**
 * 1414. 和为 K 的最少斐波那契数字数目
 *
 * @author chen yu
 * @create 2022-02-03 20:27
 */
public class Solution1414 {


    public static void main(String[] args) {
        Solution1414 solution1414 = new Solution1414();
        int ans = solution1414.findMinFibonacciNumbers(7);
        System.out.println(ans);

    }

    public int findMinFibonacciNumbers(int k) {
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(1);

        int a=1;
        int b=1;
        while (b<=k){
            int num=a+b;
            if(num<=k)  nums.add(num);
            a=b;
            b=num;
        }

        int count=0;

        int i=nums.size()-1;

         while (k>=0&&i>=0){
             k= k-nums.get(i);

             if(k<0){
                 k= k+nums.get(i);
                 i--;
                 continue;
             }
             count++;
         }
        return count;
    }

}
