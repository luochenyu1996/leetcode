import java.util.LinkedList;

/**
 * 322. 零钱兑换
 *
 * @author chen yu
 * @create 2021-11-10 11:23
 */
public class Solution322 {

    public static void main(String[] args) {

        int[] coins = {2};
        int amount = 3;
        Solution322 solution332 = new Solution322();
        int i = solution332.coinChange(coins, amount);
        System.out.println(i);
    }


    /**
     * 动态规划
     *
     */
    public  int coinChange(int[] coins, int amount) {
        //0-amount 目标数 需要的硬币数量 dp[i]=
        int[] dp = new int[amount + 1];

        int length = coins.length;

        for (int i = 1; i <= amount; i++) {
            int minCount=Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                if(i-coins[j]>=0){
                    if(dp[i-coins[j]]==-1){
                        continue;
                    }else {
                        minCount=Math.min(dp[i-coins[j]]+1,minCount);
                    }

                }
            }
            dp[i]= minCount==Integer.MAX_VALUE?-1:minCount;
        }
        return dp[amount];
    }
}
