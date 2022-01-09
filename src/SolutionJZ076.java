import java.util.PriorityQueue;

/**
 * 剑指 Offer II 076. 数组中的第 k 大的数字
 *
 * @author chen yu
 * @create 2021-12-28 11:27
 */
public class SolutionJZ076 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> a - b
        );
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if(!queue.isEmpty()&& queue.peek()<nums[i]){
                queue.poll();
                queue.offer(nums[i]);
            }

        }
        return queue.peek();
    }

}
