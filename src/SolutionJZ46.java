/**
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * @author chen yu
 * @create 2021-11-09 19:31
 */
public class SolutionJZ46 {
    public static void main(String[] args) {
        int num=122;
        String s = String.valueOf(num);
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int out = array[i] - '0';
            System.out.print(out);
        }

    }


    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] array = s.toCharArray();

        //以下标i能翻译的种类数
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            //如果取一位则没有变化
            dp[i] = dp[i - 1];
            //取当前位 和前一位
            int currentNum = 10 * (array[i - 1] - '0') + (array[i] - '0');
            if (currentNum > 9 && currentNum < 26) {
                if (i - 2 < 0) {
                    dp[i]++;
                } else {
                    dp[i] = dp[i] + dp[i - 2];
                }

            }
        }
        return dp[len - 1];

    }


}
