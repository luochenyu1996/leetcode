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
        int[][] intervals={ {1,3},{2,6},{8,10},{15,18}};
        Solution56 solution56 = new Solution56();
        int[][] merge = solution56.merge(intervals);

    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int length = intervals.length;

        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(intervals));



        for (int i = 0; i < list.size()-1; i++) {
            while (i<list.size()-1&&list.get(i)[1]>= list.get(i+1)[0]){
                //合并
                int max = Math.max(list.get(i)[1], list.get(i + 1)[1]);
                list.get(i)[1]=max;
                list.remove(i+1);
            }
        }


        int size = list.size();
        int[][] ans= new int[size][2];

        for (int i = 0; i < size; i++) {
            ans[i][0]=list.get(i)[0];
            ans[i][1]=list.get(i)[1];
        }
        return ans;

    }

}
