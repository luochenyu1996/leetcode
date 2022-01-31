package Sort;

import java.util.Random;

/**
 * 快排
 *
 * @author chen yu
 * @create 2022-01-07 17:23
 */
public class QuickSortSolution {
    Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int[] nums={1,5,3,6,3,6,7,0};
        QuickSortSolution quickSortSolution = new QuickSortSolution();
        quickSortSolution.quickSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    /**
     *  增加了随机的版本
     *
     */
    private  void  quickSort(int[] nums,int left ,int right){
        if(right<=left){
            return;
        }
        int index=partition(nums,left,right);
        quickSort(nums,left,index-1);
        quickSort(nums,index+1,right);
    }

    private  int partition(int[]  nums, int left , int right){
        int randomIndex = left+random.nextInt(right - left + 1);
        swap(nums,left,randomIndex);
        int pivot=nums[left];
        int lt=left;
        for (int i = left+1; i <= right; i++) {
            //小于则要进行交换
            if(nums[i]<pivot){
                //往前走一步再进行交换
                lt++;
                swap(nums,i,lt);
            }
        }
        //最后再进行一次交换
        swap(nums,left,lt);
        return  lt;
    }

    private  void swap(int[]  nums,int index1,int index2 ){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }


}
