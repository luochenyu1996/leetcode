/**
 * 45. 跳跃游戏 II
 *
 * @author chen yu
 * @create 2021-11-16 21:14
 */
public class Solution45 {

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        int ans = solution45.jump(new int[]{2,3,1,2,4,2,3});
        System.out.println();
        System.out.println(ans);

    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }


}
