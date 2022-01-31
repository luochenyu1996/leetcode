package BinarySearch;

/**
 * 二分查找的二中写法
 *
 * @author chen yu
 * @create 2022/1/19
 */
public class Solution2 {

     /**
      * 这种写法的特点是 left<right  right+(right-left)/2  向下取整
      *
      */

    public int search(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left < right) {
            //这里是向下取整数  对应  left
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;

            } else {
                right = mid;
            }

        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
