import java.util.Arrays;

/**
 * 561. 数组拆分 I
 *
 * @author chen yu
 * @create 2021-12-29 12:25
 */
public class Solution561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans=0;

        for (int i = 0; i < nums.length; i++) {
            ans+=nums[i++];
        }

        return ans;
    }
}
