import java.util.HashSet;

/**
 * 202. 快乐数
 *
 * @author chen yu
 * @create 2021-11-11 21:54
 */
public class Solution202 {
    public static void main(String[] args) {
        boolean res = isHappy(19);
        System.out.println(res);

    }

    public static boolean isHappy(int n) {
        int next=n;
        HashSet<Integer> set = new HashSet<>();
        while(true) {
            next = getNext(next);
            if (next == 1) {
                return true;
            }
            if (!set.add(next)) {
                return false;
            }
        }
    }

    private static int getNext(int n) {
        int totalSum = 0;
        while (n != 0) {
            int x = n % 10;
            int y = n / 10;
            n = y;
            totalSum = totalSum + x * x;
        }
        return totalSum;


    }
}
