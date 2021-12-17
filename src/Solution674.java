import java.util.ArrayDeque;

/**
 * 674. 最长连续递增序列
 *
 * @author chen yu
 * @create 2021-12-02 22:12
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int len = nums.length;
        int maxCount=0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty()&&stack.peek()>=nums[i]){

                maxCount= Math.max(maxCount,stack.size());
                stack.clear();
            }
            stack.push(nums[i]);
        }
        maxCount=Math.max(maxCount,stack.size());
        return maxCount;
    }
}
