import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 455. 分发饼干
 *
 * @author chen yu
 * @create 2021-12-28 18:36
 */
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        int  count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        while (i<s.length&&j<g.length) {
            if(s[i]>=g[j]){
                count++;
                j++;
            }
            i++;
        }

        return count;
    }
}
