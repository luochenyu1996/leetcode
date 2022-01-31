package DynamicProgramming;

/**
 * 完全背包
 *
 * @author chen yu
 * @create 2022/1/20
 */
public class Solution02 {
    /**
     * W :背包的最大重量
     * weights[]: 每个物品的重量
     * values[]:每个物品的价值
     */
    public int backpackComplete(int W, int[] weights, int[] values) {
        int N = weights.length;
        if (N == 0) {
            return 0;
        }
        // dp[i][j] 表示：考虑物品区间 [0..i] 里，不超过背包容量 j，能够获得的最大价值总和，由于包含价值为 0 的计算，所以 + 1
        int[][] dp = new int[N][W + 1];
        // 初始化：先写第 1 行。只用第一个物品放的情况   k 表示某个物品的个数
        for (int k = 0; k * weights[0] <= W; k++) {
            dp[0][k * weights[0]] = k * values[0];
        }
        // 递推开始  第一个物品已经放过了
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                // 多一个 for 循环，枚举下标为 i 的物品可以选择的个数
                for (int k = 0; k * weights[i] <= j; k++) {
                    //枚举所有可能 放 0 个 i   放 1 个i   放2个i  ...
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weights[i]] + k * values[i]);
                }
            }
        }
        return dp[N - 1][W];
    }


}
