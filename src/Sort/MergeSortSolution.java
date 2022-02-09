package Sort;

/**
 * 归并排序
 *
 * @author chen yu
 * @create 2022-02-07 21:32
 */
public class MergeSortSolution {
    public static void main(String[] args) {
        int []  nums={-4,0,7,4,9,-5,-1,0,-7,-1};
        MergeSortSolution mergeSortSolution = new MergeSortSolution();
        mergeSortSolution.sortArray(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    public  void  sortArray(int[] nums){
        int  left=0;
        int  right=nums.length-1;
        mergeSort(nums,left,right);

    }

    private void mergeSort(int[] nums, int left,int right){
        if(right==left){
            return ;
        }

        int mid=left+(right-left)/2;

        //对左边的元素进行归并
        mergeSort(nums,left,mid);
        //对右边的元素进行归并
        mergeSort(nums,mid+1,right);
        //合并左边和右边的两个有序序列
        mergeTwoSortedArray(nums,left,mid,right);
    }

    private void mergeTwoSortedArray(int[] nums,int left,int mid,int right){
        //需要使用一个额外的数组
        int len=right-left+1;
        int[] temp_nums= new int[len];
        //把原来数组的元素复制到临时数组
        for(int index=0 ;index<len;++index){
            temp_nums[index]=nums[left+index];
        }

        //开始合并

        //两个有序数组在临时数组中起始位置
        int begin_1=0;
        int begin_2=mid-left+1;

        for(int index=0;index<len;++index){
            //先判断两种越界的情况
            if(begin_1==mid-left+1){
                //只有右边的数组
                nums[left+index]=temp_nums[begin_2++];
            }else if(begin_2==right-left+1){
                //只有左边的数组
                nums[left+index]=temp_nums[begin_1++];
            }else if(temp_nums[begin_1]<temp_nums[begin_2]){
                // 左边小
                nums[left+index]=temp_nums[begin_1++];
            }else {
                //右边小
                nums[left+index]=temp_nums[begin_2++];
            }
        }
    }
}
