import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 632. 最小区间
 *
 * @author chen yu
 * @create 2022/1/18
 */
public class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();
        int left=0;
        int right=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int minDiff=right-left;

        int[] points = new int[size];

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (o1, o2) ->
                        nums.get(o1).get(points[o1])
                        -nums.get(o2).get(points[o2])
                        );

        //初始化最小堆  和最大值

        for (int i = 0; i < size; i++) {
            queue.offer(i);
            max=Math.max(max,nums.get(i).get(0));
        }

        while (true){
            Integer minIndex = queue.poll();
            int currDiff=max-nums.get(minIndex).get(points[minIndex]);
            if(currDiff<minDiff){
                minDiff=currDiff;
                left=nums.get(minIndex).get(points[minIndex]);
                right=max;
            }
            //区间替换完成后 更新指针
            points[minIndex]++;
            if(points[minIndex]>=nums.get(minIndex).size()){
                break;
            }
            queue.offer(minIndex);
            //更新最大值
            max=Math.max(max,nums.get(minIndex).get(points[minIndex]));

        }
        return new int[]{left,right};
    }

}
