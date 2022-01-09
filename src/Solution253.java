import javax.swing.*;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 253. 会议室 II
 *
 * @author chen yu
 * @create 2021-12-30 12:36
 */
public class Solution253 {

    public static void main(String[] args) {
        Solution253 solution253 = new Solution253();
        int[][] intervals= {{1,5},{8,9},{8,9}};
        int i = solution253.minMeetingRooms(intervals);
        System.out.println(i);

    }
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for (int[] interval : intervals) {
            //开始时间
            pq.add(new int[]{interval[0], 1});
            //结束时间
            pq.add(new int[]{interval[1], -1});
        }
        int count = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            count += pq.remove()[1];
            max = Math.max(max, count);
        }
        return max;




    }



}
