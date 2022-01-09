import java.util.Arrays;

/**
 * 1029. 两地调度
 *
 * @author chen yu
 * @create 2021-12-31 10:45
 */
public class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        // 假设所有的人都去城市 A
        int res = 0;
        for (int[] cost : costs) {
            res += cost[0];
        }

        // 按照城市 B - 城市 A 差值升序排序，数值越小，加到总和以后得到的结果越小
        Arrays.sort(costs, (o1, o2) -> (o1[1] - o1[0]) - (o2[1] - o2[0]));

        // 选择前一半的人改到城市 B
        int len = costs.length / 2;
        for (int i = 0; i < len; i++) {
            res += (costs[i][1] - costs[i][0]);
        }
        return res;
    }


}
