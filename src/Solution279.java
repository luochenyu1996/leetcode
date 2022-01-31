import java.util.ArrayList;
import java.util.List;

/**
 * 279. 完全平方数
 *
 * @author chen yu
 * @create 2021-11-11 10:33
 */
public class Solution279 {
    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        int i =solution279.numSquares(12);
        System.out.println(i);
    }

    public  int numSquares(int n) {
        //状态定义  dp[i] : 和为i的完全平方数的最少个数
        //状态转移： dp[i]=dp[i-j*j]+1
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //最坏的情况
            dp[i]=i;
            for (int j = 1; j*j < i; j++) {
                    dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
