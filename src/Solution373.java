import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的K对数字
 *
 * @author chen yu
 * @create 2022/1/14
 */
public class Solution373 {

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 2;
        Solution373 solution373 = new Solution373();
        List<List<Integer>> lists = solution373.kSmallestPairs(nums1, nums2, k);
        lists.forEach(System.out::println);
    }

    /**
     * [1,7,11]
     * [2,4,6]
     * [1,2] [1,4] [1,6]
     * [7,2] [7,4] [7,6]
     * [11,2] [11,4] [11,6]
     *
     *
     * [1,2]  [7,2]  [11,2]  --> [1,2]  --> [7,2] [11,2]
     * [1,4]  [7,2]  [11,2]  --> [1,4] ---> [7,2]  [11,2]
     * [7,2]  [11,2]
     * ...
     */


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (o1, o2)->{
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        //初次入队  放的是下标
        System.out.println("第一次加入的元素：");
        for (int i = 0; i < Math.min(len1, k); i++) {
            System.out.print("["+nums1[i]+","+nums2[0]+"]"+" ");
            queue.offer(new int[]{i,0});
        }
        System.out.println();

        while (k > 0 && !queue.isEmpty()) {
            int[] min = queue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[min[0]]);
            list.add(nums2[min[1]]);
            ans.add(list);
            k--;
            // 将下一个位置插入，插入后会自动排好序
            if (min[1] + 1 < len2) {
                System.out.println("加入的元素："+"["+nums1[min[0]]+","+nums2[min[1]+1]+"]");
                queue.offer(new int[]{min[0], min[1] + 1});
            }
        }
        return ans;
    }




}
