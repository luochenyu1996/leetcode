import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1405. 最长快乐字符串
 *
 * @author chen yu
 * @create 2022-02-07 19:44
 */
public class Solution1405 {

        public String longestDiverseString(int a, int b, int c) {
            PriorityQueue<int[]> q = new PriorityQueue<>((x,y)->y[1]-x[1]);
            if (a > 0) q.add(new int[]{0, a});
            if (b > 0) q.add(new int[]{1, b});
            if (c > 0) q.add(new int[]{2, c});

            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int n = sb.length();
                if (n >= 2 && sb.charAt(n - 1) - 'a' == cur[0] && sb.charAt(n - 2) - 'a' == cur[0]) {
                    if (q.isEmpty()) break;
                    int[] next = q.poll();
                    sb.append((char)(next[0] + 'a'));
                    if (--next[1] != 0) q.add(next);
                    q.add(cur);
                } else {
                    sb.append((char)(cur[0] + 'a'));
                    if (--cur[1] != 0) q.add(cur);
                }
            }
            return sb.toString();
        }
}
