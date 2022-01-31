
/**
 * 334. 递增的三元子序列
 * 一般的动态规划会超时
 * 需要改进
 *
 * @author chen yu
 * @create 2022-01-12 09:38
 */
public class Solution334 {
    // 方法二：LIS最优解：动态规划（贪心） + 二分


    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int length = nums.length;
        int[] dp = new int[length];
        //  状态定义 dp[i] 表示指定序列中  长度为i的最长上升子序列的最小结尾元素
        //  状态转移方程：
        //  1. 遍历序列时，如果当前元素大于dp[i]，将其添加到DP数组末尾dp[i+1]
        //  2.如果当前元素小于等于dp[i]，通过二分的方式查找当前元素应该放到的DP数组中的位置dp[i - 1] < nums[i] < dp[i]，并更新
        dp[0] = nums[0];
        int len = 1;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            //大于的情况
            if (num > dp[len - 1]) {
                dp[len++] = num;
                if (len >= 3) {
                    return true;
                }
                continue;
            }

            //二分查找
            int left = 0;
            int right = len - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (dp[mid] >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            dp[right] = num;
            if (len >= 3){
                return true;
            }
        }
        return false;
    }

}
