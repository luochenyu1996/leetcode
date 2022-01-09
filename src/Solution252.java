import java.util.Arrays;
import java.util.Comparator;

/**
 * 252. 会议室
 *
 * @author chen yu
 * @create 2021-12-30 12:32
 */
public class Solution252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);

        int length = intervals.length;

        for (int i = 0; i < length-1; i++) {
            if(intervals[i][1]>intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
