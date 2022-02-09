import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;

/**
 * 1725. 可以形成最大正方形的矩形数目
 */

public class Solution1725 {



    public int countGoodRectangles(int[][] rectangles) {
        int rows = rectangles.length;


        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < rows; i++) {
            int[] temp = rectangles[i];
            int small = Math.min(temp[0], temp[1]);
            map.put(small, map.getOrDefault(small, 0) + 1);
        }
        int maxKey = Integer.MIN_VALUE;
        for (Integer integer : map.keySet()) {
            maxKey = Math.max(maxKey, integer);
        }
        return map.get(maxKey);
    }

}




