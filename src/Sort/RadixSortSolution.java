package Sort;

/**
 * 基数排序
 *
 * @author chen yu
 * @create 2021-11-15 10:54
 */
public class RadixSortSolution {

    public static void main(String[] args) {
        RadixSortSolution radixSortSolution = new RadixSortSolution();
        int[] nums={231,434,432,234};

        radixSortSolution.sort(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void sort(int[] nums) {
        int len = nums.length;
        // 第 1 步：找出最大的数字
        int max = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < 0) {
                throw new IllegalArgumentException("该数组不适合使用计数排序");
            }
        }


        int maxLen = getMaxLen(max);

        // 第 3 步：每一趟都使用计数排序
        int[] count = new int[10];
        int[] temp = new int[len];

        //个位  十位 百位 ......
        int divisor = 1;


        // 有几位数，外层循环就得执行几次,依次用个十百。。。位置进行排序
        for (int i = 0; i < maxLen; i++) {
            countingSort(nums, temp, divisor,count);
            System.arraycopy(temp, 0, nums, 0, len);
            divisor *= 10;
        }
    }


    /**
     * 前缀和的 计数学排序 稍微做了修改
     *
     */
    private void countingSort(int[] nums, int[] temp, int divisor, int[] count) {
        // 内层循环得把数组从头到尾看一遍
        int len=nums.length;

        for (int j = 0; j < len; j++) {
            // 计算数位上的数是几，先取个位，再十位、百位
            int remainder = (nums[j] / divisor) % 10;  //可以得到每个位置上的数
            //根据数位进行计数
            count[remainder]++;
        }


        for (int j = 1; j < 10; j++) {
            count[j] += count[j - 1];
        }

        for (int j = len - 1; j >= 0; j--) {
            int remainder = (nums[j] / divisor) % 10;
            int index = count[remainder] - 1;
            temp[index] = nums[j];
            count[remainder]--;
        }

        // 重置数组 count，以便下次使用
        for (int j = 0; j < 10; j++) {
            count[j] = 0;
        }
    }


    private int getMaxLen(int num) {
        int maxLen = 0;
        while (num > 0) {
            num /= 10;
            maxLen++;
        }
        return maxLen;
    }
}
