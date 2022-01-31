import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 313. 超级丑数
 *
 * @author chen yu
 * @create 2022/1/17
 */
public class Solution313 {


    public int nthSuperUglyNumber(int n, int[] primes) {
        int length = primes.length;

        int[] dp = new int[n + 1];
        int[] multiple = new int[length];
        int[] index = new int[length];
        Arrays.fill(multiple, 1);
        for (int i = 1; i < n; i++) {
            int min = Arrays.stream(multiple).min().getAsInt();
            dp[i] = min;
            for (int j = 0; j < length; j++) {
                if (min == multiple[j]) {
                    index[j]++;
                    multiple[j] = dp[index[j]] * primes[j];
                }
            }
        }
        return dp[n + 1];
    }
}
