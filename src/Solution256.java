/**
 * 256. 粉刷房子
 *
 * @author chen yu
 * @create 2021-11-21 19:19
 */
public class Solution256 {

    public static void main(String[] args) {
        Solution256 solution256 = new Solution256();
       int [][] cost={{7,6,2}};
        int i = solution256.minCost(cost);
        System.out.println(i);
    }
    public int minCost(int[][] costs) {
        int roomCount = costs.length;
        int[][] dp = new int[roomCount][3];
        if(roomCount<1){
            return  0;
        }

        System.arraycopy(costs[0], 0, dp[0], 0, 3);


        for (int i = 1; i < roomCount; i++) {
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+costs[i][2];
        }

        int ans=dp[roomCount-1][0];
        for (int i = 0; i < 3; i++) {
             ans=Math.min(dp[roomCount-1][i],ans);
        }
        return  ans;
    }

}
