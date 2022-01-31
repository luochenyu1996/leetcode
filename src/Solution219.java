import java.util.HashMap;

/**
 * 219. 存在重复元素 II
 *
 * @author chen yu
 * @create 2022/1/19
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();

        int len= nums.length;

        for(int i=0;i<len;i++){
            if(map.containsKey(nums[i])){
                int dis=Math.abs(map.get(nums[i])-i);
                if(dis<=k){
                    return true;

                }
            }
            map.put(nums[i],i);

        }
        return false;
    }
}
