import java.util.Arrays;

/**
 * 377. 组合总和 Ⅳ
 *
 * @author chen yu
 * @create 2021-11-11 15:09
 */
public class Solution377 {


    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 4};
        int target = 4;

        int i = combinationSum4(nums, target);
        System.out.println(i);
    }

    public static int combinationSum4(int[] nums, int target) {
        //dp[i] 表示 整数 i  有多少种方案
        int[] dp= new int[target+1];
        dp[0]=1;
        for(int i= 1;i<=target;i++){
            for(int num:nums){
                if(i-num>=0){
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
