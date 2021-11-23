/**
 * 91. 解码方法
 *
 * @author chen yu
 * @create 2021-11-09 19:58
 */
public class Solution91 {

    public static void main(String[] args) {
        String s = "10";
        int i = numDecodings(s);
        System.out.println(i);

    }

    public static int numDecodings(String s) {

        char[] array = s.toCharArray();
        int len = array.length;
        if (len < 1) {
            return len;
        }
        if (array[0] - '0' == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (array[i] - '0' > 0) {
                dp[i] = dp[i - 1];
            }
            int curNum = (array[i - 1] - '0') * 10 + (array[i] - '0');
            if (curNum < 27 && curNum > 9) {
                if (i < 2) {
                    dp[i]++;
                } else {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }

}
