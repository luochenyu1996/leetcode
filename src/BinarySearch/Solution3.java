package BinarySearch;

/**
 *  二分查找的第三种写法
 *
 * @author chen yu
 * @create 2022/1/19
 */
public class Solution3 {

    /**
     * 这种泄写法的特点是 向上取整  right+(right-left+1)/2   left<right
     *
     */

    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            //向上取整
            int mid = left + (right - left+1) / 2;

            if (nums[mid] > target) {
                right=mid-1;

            } else {
                left = mid;
            }
        }
         if(nums[right]==target){
             return right;
         }
        return -1;
    }

}
