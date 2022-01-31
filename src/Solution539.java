import java.util.Arrays;
import java.util.List;

/**
 * 539. 最小时间差
 *
 * @author chen yu
 * @create 2022/1/18
 */

public class Solution539 {

    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int[] minutes = new int[size];

        for (int i = 0; i < size; i++) {
            String time = timePoints.get(i);
            String[] hoursAndMinutes = time.split(":");
            int temp=Integer.parseInt(hoursAndMinutes[0])*60+Integer.parseInt(hoursAndMinutes[1]);
            minutes[i]=temp;
        }
        Arrays.sort(minutes);
        int[] diff = new int[size];


        diff[0]=  1440+minutes[0]-minutes[size-1];
        int min=diff[0];
        for (int i = 1; i < size; i++) {
            diff[i]=minutes[i]-minutes[i-1];
            min=Math.min(diff[i],min);
        }
        return  min;
    }
}
