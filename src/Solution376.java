import java.util.Arrays;

/**
 * 376. 摆动序列
 *
 * @author chen yu
 * @create 2021-12-10 19:39
 */
public class Solution376 {

    public static void main(String[] args) {

        int[] nums = {1, 7, 4, 9, 2, 5};
        Solution376 solution376 = new Solution376();
        int i = solution376.wiggleMaxLength(nums);
        System.out.println(i);

    }

    public int wiggleMaxLength(int[] nums) {
        //计算差值
        int len = nums.length;
        if (len == 1||len==2) {
            return 1;
        }



        int[] diff = new int[len-1];

        int[] dp = new int[len-1];

        Arrays.fill(dp, 1);

        int countOfZero=0;

        for (int i = 0; i < len-1 ; i++) {
            diff[i] = nums[i + 1] - nums[i];
            if(diff[i]==0){
                countOfZero++;
            }
        }
        for (int i : diff) {
            System.out.print(i+" ");

        }
        System.out.println();

        int ans = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < i; j++) {
                if (diff[i] * diff[j] < 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }



        if(countOfZero==len-1){
            return  1;
        }else {
            return ans+1;
        }

    }


}
