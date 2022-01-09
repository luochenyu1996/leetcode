import java.util.Arrays;

/**
 * 剑指 Offer II 101. 分割等和子集
 *
 * @author chen yu
 * @create 2021-12-30 11:09
 */
public class SolutionJZ101 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        SolutionJZ101 solutionJZ101 = new SolutionJZ101();
        boolean b = solutionJZ101.canPartition(nums);
        System.out.println(b);

    }


    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int len = nums.length;

        boolean[][] dp = new boolean[len][target + 1];
        dp[0][0] = false;

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];
    }
}
