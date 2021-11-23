/**
 * 322. 零钱兑换
 *
 * @author chen yu
 * @create 2021-11-10 11:23
 */
public class Solution322 {

    public static void main(String[] args) {

        int[] coins={2};
        int amount= 3;
        int i = coinChange(coins, amount);
        System.out.println(i);

    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp =new int[amount+1];
        for(int i=1;i<=amount;++i){
            int minCount=Integer.MAX_VALUE;
            for(int coin :coins){
                if(i-coin>=0&&dp[i-coin]<Integer.MAX_VALUE){

                    int ans=dp[i-coin]+1;

                    minCount=Math.min(ans,minCount);
                }
            }
            dp[i]=minCount;
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
