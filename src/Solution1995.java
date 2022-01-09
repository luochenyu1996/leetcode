/**
 * 1995. 统计特殊四元组
 *
 * @author chen yu
 * @create 2021-12-29 12:19
 */
public class Solution1995 {
    public int countQuadruplets(int[] nums) {
        int len = nums.length;
        int count=0;
        for (int i = 3; i < len; i++) {
            for (int j = 2; j < i; j++) {
                for (int k = 1; k < j; k++) {
                    for (int l = 0; l < k; l++) {
                        if(nums[l]+nums[k]+nums[j]==nums[i]){
                            count++;
                        }
                    }
                }
            }
        }
        return  count;

    }
}
