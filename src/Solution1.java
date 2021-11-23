import java.util.HashMap;

/**
 * 1. 两数之和
 *
 * @author chen yu
 * @create 2021-11-06 10:18
 */
public class Solution1 {

    public static void main(String[] args) {
        

        int[] nums= {2,7,11,15};
        int target=9;

        int[] res = twoSum(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.print(i+" ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int [] ans=null;
        int len=nums.length;
        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
        for(int i=0;i<len;++i){
            if(map.containsKey(nums[i])){
                ans = new int[]{i, map.get(nums[i])};
            }else{
                map.put(target-nums[i],i);
            }
        }
        return ans;

    }
}
