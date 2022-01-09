import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 *
 * @author chen yu
 * @create 2021-12-08 18:23
 */
public class Solution452 {
    public static void main(String[] args) {
        int[][] points = {
                {-2147483646, -2147483645},
                {2147483646, 2147483647}
        };
        Solution452 solution452 = new Solution452();
        int minArrowShots = solution452.findMinArrowShots(points);
    }

    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return Integer.compare(o1[0], o2[0]);

        });

        int edge = points[0][1];

        int count = 1;
        for (int i = 1; i < len; i++) {
            if (edge < points[i][0]) {
                edge = points[i][1];
                count++;
            }
        }


        return count;
    }
}
