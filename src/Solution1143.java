/**
 * 1143. 最长公共子序列
 *
 * @author chen yu
 * @create 2022-01-06 17:21
 */
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1+1][len2+1];

        int ans=dp[0][0];

        //因为数组默认是0  这里省略初始化
        //下标进行了偏移
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]) ;
                }
                ans=Math.max(ans,dp[i][j]);
            }

        }
        return  dp[len1][len2];
    }
}
