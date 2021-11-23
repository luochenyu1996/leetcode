/**
 * 64. 最小路径和
 *
 * @author chen yu
 * @create 2021-11-14 16:33
 */
public class Solution64 {

    public int minPathSum(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        int[][] dp = new int[rowCount][columnCount];

        //处理第一行和第一列
        dp[0][0]=grid[0][0];
        for(int i=1; i<columnCount;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for(int i=1; i<rowCount;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }


        for(int i=1;i<rowCount;++i){
            for(int j=1;j<columnCount;++j){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return  dp[rowCount-1][columnCount-1];
    }
}
