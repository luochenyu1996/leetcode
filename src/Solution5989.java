import java.util.Arrays;

/**
 * 5989. 元素计数
 *
 * @author chen yu
 * @create 2022/1/23
 */
public class Solution5989 {


    public static void main(String[] args) {
        int[] nums={11,7,2,15};
        Solution5989 solution5989 = new Solution5989();
        int i = solution5989.countElements(nums);
        System.out.println(i);
    }

    public int countElements(int[] nums) {
        int count=0;

        int len = nums.length;
        int min=nums[0];
        int max=nums[0];
        for (int i = 0; i < len; i++) {
            min=Math.min(nums[i],min);
            max=Math.max(nums[i],max);
        }
        for (int i = 0; i < len; i++) {
            if(nums[i]!=min&&nums[i]!=max){
                count++;
            }
        }
        return  count;

    }
}
