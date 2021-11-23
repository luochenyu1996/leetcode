import java.util.Arrays;

/**
 * @author chen yu
 * @create 2021-11-01 08:36
 */
public class Solution209 {

    public int minSubArrayLen(int s, int[] nums) {
        int ans=Integer.MAX_VALUE;
        int len = nums.length;
        int[] prefix_sums = new int[len - 1];

        //统计前缀和
        for (int i = 1; i <= len; i++) {
            prefix_sums[i] = nums[i - 1] + prefix_sums[i - 1];
        }

        for (int i = 1; i <=len ; i++) {
            int target = s + prefix_sums[i - 1];
            int bound = Arrays.binarySearch(prefix_sums, target);
            ans=Math.min(ans,bound-(i-1));
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
