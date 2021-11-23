/**
 * 983. 最低票价
 *
 * @author chen yu
 * @create 2021-11-22 22:43
 */
public class Solution983 {
    public static void main(String[] args) {
        int[] days={1,4,6,7,8,20};
        int [] cost={2,7,15};
        Solution983 solution983 = new Solution983();
        int i = solution983.mincostTickets(days, cost);
        System.out.println(i);

    }


    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int lastDay = days[len - 1];
        int[] dp = new int[lastDay+1];

        int index=0;
        for (int i = 1; i <= lastDay; i++) {
            if (i!=days[index]){
                dp[i]=dp[i-1];
            }else {
                int cost1=dp[Math.max(0,i-1)]+costs[0];
                int cost2=dp[Math.max(0,i-7)]+costs[1];
                int cost3=dp[Math.max(0,i-30)]+costs[2];
                int min = min(cost1, cost2, cost3);
                dp[i]=min;
                index++;
            }
        }
        return dp[lastDay];

    }

    private int min(int num1,int num2,int num3){
        int min=num1;
        if(num1>num2){
            min=num2;
        }
        if(min>num3){
            min=num3;
        }
        return min;
    }

}
