

public class Solution747 {
    public int dominantIndex(int[] nums) {
        int length = nums.length;

        int maxValue = nums[0];
        int maxIndex = 0;
        for (int i = 0; i < length; i++) {
            if (maxValue < nums[i]) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }

        int leftIndex = 0;
        int rightIndex = length - 1;

        boolean flag_1 = false;
        boolean flag_2 = false;
        while (nums[leftIndex] < maxValue) {
            if (nums[leftIndex] * 2 > maxValue) {
                flag_1 = true;
                break;
            }
            leftIndex++;
        }
        while (nums[rightIndex] < maxValue) {
            if (nums[rightIndex] * 2 > maxValue) {
                flag_2 = true;
                break;
            }
            rightIndex--;
        }
        if (flag_1 || flag_2) {
            return -1;
        }
        return maxIndex;

    }


}
