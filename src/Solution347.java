import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 347. 前 K 个高频元素
 *
 * @author chen yu
 * @create 2021-12-28 11:34
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->b[1]-a[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
          map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Integer key : map.keySet()) {
         queue.offer(new int[] {key,map.get(key)});
        }
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i]=queue.poll()[0];
        }
        return ans;
    }
}
