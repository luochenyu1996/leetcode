/**
 * 213. 打家劫舍 II
 *
 * @author chen yu
 * @create 2021-11-13 10:57
 */
public class Solution213 {

    public static void main(String[] args) {

        int[] nums= {1,2,3,1};
        int rob = rob(nums);
        System.out.println(rob);

    }

    public static int rob(int[] nums) {
        int len = nums.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];

        if(len==1){
            return nums[0];
        }
        if(len==2){
            return Math.max(nums[0],nums[1]) ;
        }

        //1.不偷第一个
        dp1[0]=0;
        dp1[1]=nums[1];
        dp1[2]=Math.max(nums[2], nums[1]);

        for (int i = 3; i < len; i++) {
            dp1[i]=Math.max(dp1[i-2]+nums[i],dp1[i-1]);
        }

        //2.不偷最后一个
        dp2[0]=nums[0];
        dp2[1]=Math.max(nums[0], nums[1]) ;
        for (int i = 2; i < len-1; i++) {
            dp2[i]=Math.max(dp2[i-2]+nums[i],dp2[i-1]);
        }

        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            ans= Math.max(ans,Math.max(dp1[i],dp2[i])) ;
        }
        return  ans;
    }
}
