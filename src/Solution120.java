import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @author chen yu
 * @create 2021-11-13 15:25
 */
public class Solution120 {

    public static void main(String[] args) {

    }


    public int minimumTotal(List<List<Integer>> triangle) {

        int rowSize= triangle.size();
        int cloumSize= triangle.get(rowSize-1).size();
        int[][] dp= new int[rowSize][cloumSize];

        if(triangle.size()==1&&triangle.get(0).size()==1){
            return triangle.get(0).get(0);
        }

        //第一列
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<rowSize;++i){
            dp[i][0]=triangle.get(i).get(0)+dp[i-1][0];
        }

        int ans=Integer.MAX_VALUE;

        for(int i=1;i<rowSize;++i){
            for(int j=1;j<triangle.get(i).size();++j){
                if(j==triangle.get(i).size()-1){
                    dp[i][j]= dp[i-1][j-1] +triangle.get(i).get(j);

                }else{
                    dp[i][j]= Math.min(dp[i-1][j],dp[i-1][j-1]) +triangle.get(i).get(j);
                }

            }
        }
        for(int i=0;i<cloumSize;++i){
            ans=Math.min(dp[rowSize-1][i],ans);

        }
        //每行的最后一个位置
        return ans;
    }
}
