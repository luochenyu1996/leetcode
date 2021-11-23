/**
 * 63. 不同路径 II
 *
 * @author chen yu
 * @create 2021-11-14 16:18
 */
public class Solution63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rowCount = obstacleGrid.length;
        int columnCount = obstacleGrid[0].length;
        int[][] dp = new int[rowCount][columnCount];

        //处理第一行和第一列
        for(int i=0;i<columnCount;++i){
            if(obstacleGrid[0][i]!=1){
                dp[0][i]=1;
            }else{
                while(i<columnCount){
                    dp[0][i++]=0;
                }
            }
        }

        for(int i=0;i<rowCount;++i){
            if(obstacleGrid[i][0]!=1){
                dp[i][0]=1;
            }else{
                while(i<rowCount){
                    dp[i++][0]=0;
                }
            }
        }

        for(int i=1;i<rowCount;++i){
            for(int j=1;j<columnCount;++j){
                if(obstacleGrid[i][j]!=1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[rowCount-1][columnCount-1];
    }
}
