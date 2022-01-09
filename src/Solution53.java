import java.util.Arrays;

/**
 * 53. 最大子数组和
 *
 * @author chen yu
 * @create 2021-12-01 22:44
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;


        int[] dp = Arrays.copyOf(nums, len);
        int ans=dp[0];
        for (int i = 1; i < len; i++) {
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }else {
                dp[i]=nums[i];
            }

            ans= Math.max(ans,dp[i]);

        }
        return ans;
    }
}
