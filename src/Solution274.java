import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 274. H 指数
 *
 * @author chen yu
 * @create 2022-01-04 22:19
 */
public class Solution274 {


    public static void main(String[] args) {
        Solution274 solution274 = new Solution274();
        int[] citations = {1,1};
        int i = solution274.hIndex(citations);
        System.out.println(i);
    }

    public int hIndex(int[] citations) {

            Arrays.sort(citations);
            for (int i = 0; i < citations.length; i++) {
                int h = citations.length - i;
                if (h <= citations[i]) {
                    return h;
                }
            }
            return 0;
        }
}
