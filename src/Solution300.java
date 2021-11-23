import java.util.ArrayDeque;

/**
 * 300. 最长递增子序列
 *
 * @author chen yu
 * @create 2021-11-05 12:25
 */
public class Solution300 {
    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        int ans = lengthOfLIS(nums);
        System.out.println(ans);

    }

    public static int lengthOfLIS(int[] nums) {
        ArrayDeque<Integer>  statck=  new ArrayDeque<Integer>();
        int len=nums.length;
        int ans=0;
        int i=0;
        while (i<len){
            while(i<len&&(statck.isEmpty()||statck.peek()<nums[i])){
                statck.push(nums[i++]);
            }
            ans=Math.max(ans,statck.size());
            statck.clear();

        }
        return ans;

    }

}
