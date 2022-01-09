import java.util.Arrays;
import java.util.Comparator;

/**
 * 1710. 卡车上的最大单元数
 *
 * @author chen yu
 * @create 2021-12-31 09:51
 */
public class Solution1710 {

    public static void main(String[] args) {

       int[][] boxTypes =  {{1,3},{2,2},{3,1}};
        Solution1710 solution1710 = new Solution1710();
        int i = solution1710.maximumUnits(boxTypes,4);
        System.out.println(i);
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int ans = 0;
        int i = 0;
        int len = boxTypes.length;
        while (truckSize > 0 && i < len) {
            while (boxTypes[i][0] >0  && truckSize > 0) {
                truckSize = truckSize - 1;
                ans += boxTypes[i][1];
                boxTypes[i][0]--;
            }
            i++;
        }
        return ans;

    }
}
