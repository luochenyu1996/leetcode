import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 *
 * @author chen yu
 * @create 2022-02-11 14:06
 */
public class Solution1984 {

    public static void main(String[] args) {
        int[] nums ={9,4,1,7};
        Solution1984 solution1984 = new Solution1984();
        int i = solution1984.minimumDifference(nums, 2);
        System.out.println(i);
    }
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int len = nums.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i+k<=len;i++){
            min=Math.min(min,nums[i+k-1]-nums[i]);
        }
        return  min;
    }
}
