/**
 * 55. 跳跃游戏
 *
 * @author chen yu
 * @create 2021-11-16 20:16
 */
public class Solution55 {
    //这种DP 是很暴力的  应该用更高效率的贪心去做
    public boolean canJump(int[] nums) {
        int len=  nums.length;
        boolean[]  dp= new boolean[len];
        if(len==0||len==1){
            return true;
        }
        dp[0]=nums[0]==0?false:true;
        for(int i=0;i<len;i++){
            for(int j=1;j<=nums[i];++j){
                if(j+i>=len){
                    break;
                }

                dp[j+i]=true&&dp[i];

            }
        }
        return  dp[len-1];
    }
}
