import java.util.HashMap;

/**
 * 912. 排序数组
 *
 * @author chen yu
 * @create 2021-11-05 22:10
 */
public class Solution912 {

    public static void main(String[] args) {
       int[] nums=  {-1,2,-8,-10};
        int[] ans = sortArray(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }


    //使用选择排序
    public static   int[] sortArray(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len;i++){
            int min=i;
            for(int j=i;j<len ;j++){
                if(nums[min]>nums[j]){
                    min=j;
                }
            }
            swap(min,i,nums);
        }
        return nums;
    }

    private  static void swap(int index1,int index2,int[] nums ){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
}
