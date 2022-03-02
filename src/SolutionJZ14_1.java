/**
 * 剑指 Offer 14- I. 剪绳子
 *  动态规划
 * @author chen yu
 * @create 2022-03-01 20:41
 */
public class SolutionJZ14_1 {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1]=1;
        for (int i = 2; i < n; i++) {
            int curMax=0;
            for (int j = 1; j < i; j++) {
                 curMax= Math.max(curMax,Math.max(j*(i-j), j*dp[i-j]));
            }
            dp[i]=curMax;
        }
        return dp[n];
    }

}
