package sort;

import java.util.Arrays;

/**
 * 计数排序--基本版本
 *
 * @author chen yu
 * @create 2021-11-12 14:59
 */
public class ContSortSolution {

    public static void main(String[] args) {

        int [] nums ={2, 5, 3, 0, 2, 3, 0, 3};
        ContSortSolution contSortSolution = new ContSortSolution();
        contSortSolution.contSort(nums);

    }

    public  void contSort(int[] nums) {
        int len = nums.length;
        int max=nums[0];
        //找到数组中的最大值
        for (int i = 0; i < len; i++) {
            max=Math.max(nums[i],max);
        }

        //计数数组
        int[] counts = new int[len + 1];
        for (int i = 0; i < len; i++) {
            counts[nums[i]]++;
        }
        //计数数组改变为前缀数组,通过前缀数组推算出这个元素所在的位置
        for(int i=1;i<len;i++){
            counts[i]=counts[i]+counts[i-1];
        }

        //对原数组进行一个拷贝
        int[] tempArray = Arrays.copyOf(nums, len);

        //从前往后扫描，依次把看到的数组写会原始数组，从前往后是为了保证稳定性

        for (int i=len-1;i>=0;i--){
            //计算每个元素应该放的位置
            int position=counts[tempArray[i]]-1;
            nums[position]=tempArray[i];
            //前缀和减1
            counts[tempArray[i]]--;
        }





    }

}
