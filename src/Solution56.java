import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @author chen yu
 * @create 2021-12-08 14:26
 */
public class Solution56 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution56 solution56 = new Solution56();
        int[][] merge = solution56.merge(intervals);

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int length = intervals.length;
        int[][] ans = new int[length][2];

        int newIndex = -1;
        for (int[] interval : intervals) {
            //不重合
            if (newIndex == -1 || interval[0] > ans[newIndex][1]) {
                ans[++newIndex] = interval;
            } else {
                //重合
                ans[newIndex][1] = Math.max(ans[newIndex][1], interval[1]);
            }

        }
        return Arrays.copyOf(ans, newIndex + 1);

    }


}
