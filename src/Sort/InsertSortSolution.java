package Sort;

/**
 * @author chen yu
 * @create 2021-11-06 11:49
 */
public class InsertSortSolution {
    public static void main(String[] args) {
        int[] nums={5,2,3,1};
        insertSort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    public  static void insertSort(int[] nums) {
        //找出最小值
        int min = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[min] > nums[i]) {
                min = i;
            }
        }
        swap(min, 0, nums);

        for (int j = 1; j < len; j++) {
            int temp = nums[j];
            int k = j;
            while (nums[k - 1] > temp) {
                nums[k] = nums[k - 1];
                k--;
            }
            nums[k] = temp;
        }

    }

    private static void swap(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
