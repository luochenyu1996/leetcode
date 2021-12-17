package Lz;

import java.util.Arrays;

/**
 * 数组中心下标
 *
 * @author chen yu
 * @create 2021-10-30 14:37
 */
public class LZ01 {

    public static void main(String[] args) {
        int[] nums = {2, 1, -1};
        int ans = pivotIndex(nums);
        System.out.println(ans);
    }

    public static int pivotIndex(int[] nums) {

      
        //前缀和
        int len = nums.length;
        int sum_left = 0;
        int sum=0;
        for (int i = 0; i < len; i++) {
            sum+=nums[i];
        }

        for (int i = 0; i < len; i++) {
            if (2 * sum_left + nums[i] == sum) {
                return  i;
            }
            sum_left += nums[i];
        }
        return -1;
    }
}
