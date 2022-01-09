import java.util.Arrays;

/**
 * 152. 乘积最大子数组
 *
 * @author chen yu
 * @create 2022-01-06 12:20
 */
public class Solution152 {

    public int maxProduct(int[] nums) {
        int len= nums.length;
        //dp[i] 以元素i结尾的 子数组 中 最大乘积
        int[] dpMin = new int[len];
        int[] dpMax = new int[len];
        int ans=dpMax[0];
        dpMax[0]=nums[0];
        dpMin[0]=nums[0];
        for(int i=1;i<len;i++){
            if (nums[i] >= 0) {
                dpMax[i] = Math.max(nums[i],dpMax[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dpMin[i - 1] * nums[i]);
            } else {
                dpMax[i] = Math.max(nums[i], dpMin[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dpMax[i - 1] * nums[i]);
            }
            ans=Math.max(dpMax[i],ans);

        }
        return  ans;
    }


}
