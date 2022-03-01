/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * @author chen yu
 * @create 2022-03-01 19:15
 */
public class SolutionJZ10_2 {
    public int numWays(int n) {
        int[] dp = new int[n+1];
        if(n==0){
            return 1;
        }
        dp[0]=1;
        dp[1]=1;


        for(int i=2;i<=n;i++){

            dp[i]=dp[i-1]+dp[i-2];
            dp[i]%=1000000007;
        }
        return dp[n];
    }
}
