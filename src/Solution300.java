import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 300. 最长递增子序列
 *
 * @author chen yu
 * @create 2021-11-05 12:25
 */
public class Solution300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution300 solution300 = new Solution300();
        int i = solution300.lengthOfLIS(nums);
        System.out.println(i);

    }

    public int lengthOfLIS(int[] nums) {
        int len= nums.length;
        int[] dp= new int[len];
        Arrays.fill(dp,1);
        int ans=dp[0];
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) {
                    dp[i]=  Math.max(dp[i],dp[j]+1);
                }
            }
            ans=Math.max(dp[i],ans);
        }
        return  ans;
    }

}
