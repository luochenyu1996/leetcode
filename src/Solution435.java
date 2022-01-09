import javax.swing.plaf.IconUIResource;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 435. 无重叠区间
 *
 * @author chen yu
 * @create 2021-12-08 17:11
 */
public class Solution435 {
    /**
     * dp 超时了
     *
     */

    public static void main(String[] args) {
        Solution435 solution435 = new Solution435();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int i = solution435.eraseOverlapIntervals(intervals);
        System.out.println(i);
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int len = intervals.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int max = dp[0];
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                  //  max = Math.max(dp[i], max);
                }
            }
        }
        return len - Arrays.stream(dp).max().getAsInt();
    }


}
