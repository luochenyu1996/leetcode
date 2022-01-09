import java.util.ArrayDeque;

/**
 * 1614. 括号的最大嵌套深度
 *
 * @author chen yu
 * @create 2022-01-07 09:59
 */
public class Solution1614 {
    public int maxDepth(String s) {
        int len = s.length();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        int count=0;
        int ans=0;
        for (int i = 0; i < len; i++) {
            if(s.charAt(i)=='('){
                count++;
                stack.push(s.charAt(i));
            }else if(!stack.isEmpty()&&stack.peek()=='('&&s.charAt(i)==')'){
                ans=Math.max(ans,count);
                stack.pop();
                count =0;
            }

        }

        return  ans;




    }
}
