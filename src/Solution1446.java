import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Set;

/**
 * 1446. 连续字符
 *
 * @author chen yu
 * @create 2021-12-01 18:37
 */
public class Solution1446 {
    public int maxPower(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int ans=0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int maxCount=0;
            while (!stack.isEmpty()&&stack.peek()!=s.charAt(i)){
                stack.pop();
                maxCount++;
            }
            ans= Math.max(maxCount, ans);
            stack.push(s.charAt(i));
        }
        ans= Math.max(stack.size(),ans);
        return ans;
    }
}
