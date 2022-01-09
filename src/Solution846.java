import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 846. 一手顺子
 *
 * @author chen yu
 * @create 2021-12-30 10:09
 */
public class Solution846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        //放到堆中  同时放到map中
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int outNum = queue.poll();
            if (map.get(outNum) == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int count = map.getOrDefault(outNum + i, 0);
                if (count == 0) {
                    return false;
                }
                map.put(outNum + i, count - 1);
            }
        }
        return true;
    }


}
