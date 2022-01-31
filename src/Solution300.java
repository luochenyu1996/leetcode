

/**
 * 300. 最长递增子序列
 *
 * 贪心  + dp  +  二分
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
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int end = 0;
        for (int i = 0; i < len; i++) {
            //大于的时候
            if (nums[i] > dp[end]) {
                end++;
                dp[end] = nums[i];
            } else {
                //小于的时候
                int leftIndex = 0;
                int rightIndex = end;
                while (leftIndex < rightIndex) {
                    int mid = (rightIndex + leftIndex) / 2;
                    if (dp[mid] < nums[i]) {
                        leftIndex = mid + 1;
                    } else {
                        rightIndex = mid;
                    }
                }
                dp[leftIndex] = nums[i];
            }

        }
        return end+1;
    }


}
