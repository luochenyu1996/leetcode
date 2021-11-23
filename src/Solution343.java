/**
 * 343. 整数拆分
 *
 * @author chen yu
 * @create 2021-11-11 12:23
 */
public class Solution343 {

    public static void main(String[] args) {
        int i = integerBreak(10);
        System.out.println(i);
    }
    public static int integerBreak(int n) {
        //n 可以拆分为 1~n-1 之间的数进行相加   求乘积最大
        int[] dp = new int[n + 1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j=1; j < i; ++j) {
                max  = Math.max( Math.max (dp[i - j]*j,(i-j)*j), max);
            }
            dp[i] = max;
        }
        return dp[n];
    }


}
