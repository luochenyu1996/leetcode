/**
 * 1342. 将数字变成 0 的操作次数
 *
 * @author chen yu
 * @create 2022-01-31 10:46
 */
public class Solution1342 {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {

            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            count++;

        }
        return count;
    }
}
