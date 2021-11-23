import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 316. 去除重复字母
 *
 * @author chen yu
 * @create 2021-10-28 09:29
 */
public class Solution316 {

    public static void main(String[] args) {

        String  s="cbacdcbc";
        String s1 = removeDuplicateLetters(s);
        System.out.println(s1);
    }

    public static String removeDuplicateLetters(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean[] flags = new boolean[128];
        int[] counts = new int[128];
        int len =s.length();
        //统计字符串
        for(int i =0;i<len;i++){
            counts[s.charAt(i)]++;
        }

        for (int i = 0; i < len; i++) {
            char x = s.charAt(i);
            if(!flags[x]){
                while (!stack.isEmpty()&&stack.peek()>x){
                    if(counts[stack.peek()]>0 ){
                       flags[stack.peek()]=false;
                        stack.pop();
                    }else {
                        break;
                    }
                }
                stack.push(x);
                flags[x]=true;
            }
            counts[x]--;
        }

        StringBuffer stringBuffer = new StringBuffer();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(stack.removeLast());
        }
        return  stringBuffer.length()==0?"0":stringBuffer.toString();
    }


}
