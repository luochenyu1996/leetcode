/**
 * 55. 跳跃游戏
 *
 * @author chen yu
 * @create 2021-11-16 20:16
 */
public class Solution55 {

    /**
     * 解法1：动态规划
     *
     */
    public boolean canJump(int[] nums) {
        //状态定义 dp[i]  表示 ：当前的位置是否能够到达
        int  len= nums.length;
        boolean[] dp=  new boolean[len];
        dp[0]=true;
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(dp[j]){
                    if(nums[j]+j>=i){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[len-1];
    }

    /**
     * 解法2：贪心
     * 动态维护能够到的最远的位置
     *
     */
    public boolean  canJump02(int[] nums){
        int length = nums.length;
        int maxDis=nums[0];
        for (int i = 1; i < length; i++) {
              if(maxDis<i){
                  return false;
              }
              maxDis=Math.max(maxDis,i+nums[i]);
        }
        return maxDis >= length - 1;
    }

}
