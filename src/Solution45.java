/**
 * 45. 跳跃游戏 II
 *
 * @author chen yu
 * @create 2021-11-16 21:14
 */
public class Solution45 {

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        int ans = solution45.jump(new int[]{3,2,1});

        System.out.println(ans);

    }

    public int jump(int[] nums) {
        int len = nums.length;
        //状态定义  ：  dp[i] 跳到该位置上需要最少的次数
        //状态转移 ：   dp[i] dp[i-j]+1;
        int[] dp=new int[len];
        dp[0]=0;
        for(int i=1;i<len;i++){
            dp[i]=dp[i-1]+1;
            for(int j=0;j<i;j++){
                if(j+nums[j]>=i){
                    dp[i]= Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[len-1];
    }


}
