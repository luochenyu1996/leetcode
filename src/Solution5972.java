import java.util.Arrays;

/**
 * 5972. 统计隐藏数组数目
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class Solution5972 {
    public static void main(String[] args) {
        int[] differences={4,-7,2};
        int lower=3;
        int upper=6;

        Solution5972 solution5972 = new Solution5972();
        int i = solution5972.numberOfArrays(differences, lower, upper);
        System.out.println(i);
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int len = differences.length;
        int[] tempArray = new int[len + 1];
        tempArray[len]=0;


        //找最小值
        int min =tempArray[len];
        int max=tempArray[len];
        for (int i = len-1; i >=0; i--) {
            tempArray[i]=tempArray[i+1]-differences[i];
            min=Math.min(tempArray[i],min);
            max=Math.max(tempArray[i],max);

        }
        int ans=upper-lower-Math.abs(max-min)+1;
        return Math.max(ans, 0);
    }
}
