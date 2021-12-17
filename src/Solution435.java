import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 *
 * @author chen yu
 * @create 2021-12-08 17:11
 */
public class Solution435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0]));
        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        int count=0;

        for (int i = 0; i < list.size()-1; i++) {
            while ( i<list.size()-1&&list.get(i)[1]>list.get(i+1)[0]){
                if (list.get(i)[1]>list.get(i+1)[1]){
                    list.remove(i);
                }else {
                    list.remove(i+1);
                }
                count++;
            }
        }
        return count;

    }
}
