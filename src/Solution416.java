
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 416. 分割等和子集
 *
 * @author chen yu
 * @create 2021-12-29 18:32
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2!=0){
            return false;
        }

        int target=sum/2;
        int len = nums.length;
        boolean[][] dp = new boolean[len][target + 1];

        if(nums[0]<=target){
            dp[0][nums[0]]=true;
        }



        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {



//                if(nums[i]==j){
//                    dp[i][j]=true;
//                    continue;
//                }
                if(nums[i]<=j){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];

    }


}
