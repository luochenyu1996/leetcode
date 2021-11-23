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
        int i = numSquares(2);
        System.out.println(i);
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                min=Math.min(min,dp[i-j*j]);
            }
            dp[n]= min+1;
        }
        return  dp[n];
    }
}
