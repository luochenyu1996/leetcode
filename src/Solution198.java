/**
 * 198. 打家劫舍
 *
 * @author chen yu
 * @create 2021-11-13 10:37
 */
public class Solution198 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Solution198 solution198 = new Solution198();
        int rob = solution198.rob(nums);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        int len = nums.length;

        //dp[i] 前i家能偷到的最高金额
        // dp[i]=Max(dp[i-1],dp[i-2]+nums[i])
        int[] dp = new int[len];
        dp[0] = nums[0];
        if (len > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}
