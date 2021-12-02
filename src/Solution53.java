/**
 * 53. 最大子数组和
 *
 * @author chen yu
 * @create 2021-12-01 22:44
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        dp[0]=nums[0];

        int ans =dp[0];
        for (int i = 1; i < len; i++) {

            if(nums[i]+dp[i-1]<=nums[i]){
                dp[i]=nums[i];
            }else {
                dp[i]=dp[i-1]+nums[i];
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
