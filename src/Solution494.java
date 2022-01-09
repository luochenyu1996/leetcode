import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

/**
 * 494. 目标和
 *
 * @author chen yu
 * @create 2021-12-30 11:41
 */
public class Solution494 {


    public static void main(String[] args) {
        int target = 3;
        int[] nums = {1, 1, 1, 1, 1};
        Solution494 solution494 = new Solution494();
        int targetSumWays = solution494.findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }

    /**
     * 动态规划
     * <p>
     * 一个一个添加要考虑的元素，并且计算出所有恰能凑够 目标  的方案
     * <p>
     * 1.状态定义:
     * dp[i][j]：表示使用数组前缀区间前缀区间 [0..i] 里的部分元素，并且它们的和为 j 的方法数。
     * 2.状态转移方程:
     * if i>=1 and j>=nums[i]
     * dp[i][j]=dp[i−1][j−nums[i]]+dp[i−1][j+nums[i]]
     */
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int sum = Arrays.stream(nums).sum();
        if (target > sum) {
            return 0;
        }

        int X = sum + target;
        if ((X % 2) != 0) {
            return 0;
        }
        X /= 2;

        int[][] dp = new int[len][X + 1];
        dp[0][0] = 1;
        for (int j = 0; j <= X; j++) {
            if (nums[0] == j) {
                dp[0][j] += 1;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < X + 1; j++) {
                // 至少是不选这个物品时候的种数
                dp[i][j] += dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][X];
    }




}





