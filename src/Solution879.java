/**
 * 879. 盈利计划
 *
 * @author chen yu
 * @create 2022-01-05 10:49
 */
public class Solution879 {
    int mod = (int) 1e9 + 7;

    public int profitableSchemes(int n, int min, int[] gs, int[] ps) {
        int m = gs.length;
        long[][][] dp = new long[m + 1][n + 1][min + 1];

        for (int i = 0; i <= n; i++){
            dp[0][i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            int a = gs[i - 1], b = ps[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= min; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= a) {
                        int u = Math.max(k - b, 0);
                        dp[i][j][k] += dp[i - 1][j - a][u];
                        if (dp[i][j][k] >= mod){
                            dp[i][j][k] -= mod;
                        }
                    }
                }
            }
        }
        return (int) dp[m][n][min];
    }

}
