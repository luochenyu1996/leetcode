package BinarySearch;

/**
 * 二分查找的写法1
 * leetcode 704题进行验证
 *
 * @author chen yu
 * @create 2022/1/19
 */
public class Solution1 {
    /**
     * 这种写法的特点主要在于  left<=right
     *
     */
    public int search(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }

        }
        return -1;
    }

}
