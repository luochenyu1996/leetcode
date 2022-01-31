import java.util.Arrays;

/**
 * 5971. 打折购买糖果的最小开销
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class Solution5971 {
    public static void main(String[] args) {
    }

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int len = cost.length;
        int ans=0;
        int index=len-1;

        while (index>=0){
            ans+=cost[index];
            index--;
            if(index>=0){
                ans+=cost[index];
                index--;
                if(index>=0){
                    index--;
                }
            }
        }

        return ans;
    }
}
