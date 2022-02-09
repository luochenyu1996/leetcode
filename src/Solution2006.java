import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * 2006. 差的绝对值为 K 的数对数目
 *
 * @author chen yu
 * @create 2022-02-09 11:45
 */
public class Solution2006 {
    public int countKDifference(int[] nums, int k) {
        Random random = new Random(System.currentTimeMillis());

        int ans=0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int len = nums.length;

        for (int j = 0; j < len; j++) {
            ans +=(map.getOrDefault(nums[j]-k,0)+map.getOrDefault(nums[j]+k,0));
             map.put(nums[j], map.getOrDefault(nums[j],0)+1);
        }

        return ans;

    }
}
