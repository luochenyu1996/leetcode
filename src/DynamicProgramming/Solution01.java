package DynamicProgramming;

import java.util.Arrays;

/**
 * 0-1背包问题
 * https://www.acwing.com/problem/content/2/
 *
 * @author chen yu
 * @create 2022/1/20
 */
public class Solution01 {

    public int knapsackProblem_01(int W, int[] weights, int[] values) {
        int N = weights.length;
        if (N == 0) {
            return 0;
        }



        // dp[i][j] 表示：考虑物品区间 [0..i] 里，不超过背包容量 j，能够获得的最大价值，由于包含价值为 0 的计算，所以 + 1
        int[][] dp = new int[N][W + 1];
        // 初始化：先写第 1 行
        for (int j = 0; j <= W; j++) {
            // 第 1 个物品的体积要小于等于背包容量
            if (weights[0] <= j) {
                dp[0][j] = values[0];
            }
        }
        // 递推开始
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                //第一次赋值
                dp[i][j] = dp[i - 1][j];
                if (weights[i] <= j) {
                    //第二次赋值
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        return dp[N - 1][W];
    }

}
