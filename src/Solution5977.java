/**
 * 5977. 最少交换次数来组合所有的 1 II
 *
 * @author chen yu
 * @create 2022-01-09 11:16
 */
public class Solution5977 {

    public static void main(String[] args) {
        Solution5977 solution5977 = new Solution5977();
        int[] nums=  {1,1,1,0,0,1,0,1,1,0};
        int i = solution5977.minSwaps(nums);
        System.out.println(i);



    }

    public int minSwaps(int[] nums) {
       int count_one=0;
        int length = nums.length;
        //统计1
        for (int num : nums) {
            if(num==1){
                count_one++;
            }
        }

        //窗口大小
        int left=0;
        int right=count_one-1;

        int minCount=Integer.MAX_VALUE;
        int i=0;
        int count_zero=0;

        //初始窗口大小中0的个数
        while(i<=right){
            if (nums[i]==0){
                count_zero++;
            }
            i++;
        }

        while(left<length){
            minCount=Math.min(minCount ,count_zero);
            if(nums[left]==0){
                count_zero--;
            }
            int tempRight=right+1;
            if(tempRight>=length){
                tempRight=tempRight%(length);
            }
            if(nums[tempRight]==0){
                count_zero++;
            }

            left++;
            right++;
            if(right>=length){
                right=right%(length);
            }
        }
        return minCount;

    }

}
