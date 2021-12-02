import java.util.ArrayDeque;

/**
 * 300. 最长递增子序列
 *
 * @author chen yu
 * @create 2021-11-05 12:25
 */
public class Solution300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int ans = lengthOfLIS(nums);
        System.out.println(ans);

    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < len; i++) {
            int maxCount = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxCount = Math.max(maxCount, dp[j] + 1);
                }
            }
            dp[i] = maxCount;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
