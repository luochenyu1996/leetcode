import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 1217. 玩筹码
 *
 * @author chen yu
 * @create 2021-12-31 10:13
 */
public class Solution1217 {
    public int minCostToMoveChips(int[] position) {
        int count1 = 0;
        for(int i : position)
            count1 += i & 1; //奇数个数
        int count0 = position.length - count1; //偶数个数
        return count0 > count1 ? count1 : count0;
    }
}
