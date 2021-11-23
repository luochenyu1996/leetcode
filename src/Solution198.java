/**
 * 198. 打家劫舍
 *
 * @author chen yu
 * @create 2021-11-13 10:37
 */
public class Solution198 {

    public static void main(String[] args) {
        int [] nums={1,2,3,1};
        int rob = rob(nums);
        System.out.println(rob);
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if(len<2){
            return nums[0];
        }
        int[] dp = new int[len+1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]) ;
        }

        int ans=Integer.MIN_VALUE;
        for (int i : dp) {
            ans=Math.max(ans,i);
        }
        return ans;
    }
}
