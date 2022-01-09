import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 71. 简化路径
 *
 * @author chen yu
 * @create 2021-10-27 10:06
 */
public class Solution71 {

    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();
        String s = solution71.simplifyPath("/..");
        System.out.println(s);
    }
    public   String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<String>();
        String[] splitPath = path.split("/");
        int len = splitPath.length;
        for (int i = 0; i < len; i++) {
            if(splitPath[i].equals(".")||splitPath[i].equals("")){
                continue;
            }else if(splitPath[i].equals("..")&&!stack.isEmpty()){
                String pop = stack.pop();
            }else if(!splitPath[i].equals("..")){
                stack.push(splitPath[i]);
            }
        }
        StringBuffer ans = new StringBuffer();
        for (int i=stack.size();i>0;i--){
            ans.append("/"+stack.removeLast());
        }
        return ans.length()==0?"/":ans.toString();
    }



}
