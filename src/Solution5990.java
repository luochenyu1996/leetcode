import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5990. 找出数组中的所有孤独数字
 *
 * @author chen yu
 * @create 2022/1/23
 */
public class Solution5990 {


    public static void main(String[] args) {
        int [] nums={1,3,5,3};
        Solution5990 solution5990 = new Solution5990();
        List<Integer> lonely = solution5990.findLonely(nums);
        for (Integer integer : lonely) {
            System.out.print(integer+" ");
        }
    }


    public List<Integer> findLonely(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if (length==1){
           ans.add(nums[0]);
           return  ans;
        }
        for (int i = 0; i < length; i++) {
            if(i==0){
                if(nums[i+1]-1!=nums[i]&&nums[i+1]!=nums[i]){
                    ans.add(nums[i]);
                }
            }else if(i==length-1){
                if (nums[i-1]+1!=nums[i]&&nums[i-1]!=nums[i]){
                    ans.add(nums[i]);
                }
            }else {
                 if(nums[i-1]!=nums[i]&&nums[i+1]!=nums[i]&&nums[i-1]+1!=nums[i]&&nums[i+1]-1!=nums[i]){
                     ans.add(nums[i]);
                 }
            }

        }
        return ans;
    }
}
