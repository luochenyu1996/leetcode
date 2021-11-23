import java.util.ArrayDeque;

/**
 * 71. 简化路径
 *
 * @author chen yu
 * @create 2021-10-27 10:06
 */
public class Solution71 {

    public static void main(String[] args) {
        String s = simplifyPath("/home//foo/");
        System.out.println(s);
    }
    public  static String simplifyPath(String path) {
        String[] pathArray= path.split("/");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String e : pathArray) {
            if (!stack.isEmpty()&&e.equals("..")){
                stack.pop();
            }else if (!" ..".contains(e)){
                stack.push(e);
            }
        }
        StringBuffer ans = new StringBuffer();
        for (int i=stack.size();i>0;i--){
            ans.append("/"+stack.removeLast());
        }
         return ans.length()==0?"/":ans.toString();
    }


}
