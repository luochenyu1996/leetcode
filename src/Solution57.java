import java.util.ArrayList;
import java.util.Arrays;

/**
 * 57. 插入区间
 *
 * @author chen yu
 * @create 2022/1/13
 */
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int newIndex=0;
        int[][] ans = new int[len+1][2];

        int index=0;
        //左边分裂的去区间
        while (index<intervals.length&&intervals[index][1]<newInterval[0]){
             ans[newIndex++]=intervals[index];
            index++;
        }

        //中间  以 newInterval[1]  作为边界值
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }
        ans[newIndex++]=newInterval;

        //右边分离的区间
        while (index<intervals.length){
            ans[newIndex++]=intervals[index++];
        }
        return Arrays.copyOf(ans,newIndex);
    }
}
