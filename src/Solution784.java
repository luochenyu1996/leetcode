import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 *
 * @author chen yu
 * @create 2021-11-29 15:16
 */
public class Solution784 {
    ArrayList<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Solution784 solution784 = new Solution784();
        List<String> out = solution784.letterCasePermutation("abc");
        for (String s : out) {
            System.out.println(s);
        }

    }

    public List<String> letterCasePermutation(String s) {
        int len = s.length();
        dfs(0,len,s);
        return ans;
    }

    private void dfs (int index,int len,String s){
        if(index==len){
            ans.add(sb.toString());
            return;
        }
        char c = s.charAt(index);
        if('a'<=c&&c<='z'||'A'<=c&&c<='Z'){
            sb.append(Character.toLowerCase(c));
        }else {
            sb.append(c);

        }
        dfs(index+1,len,s);
        sb.deleteCharAt(sb.length()-1);


        if('a'<=c&&c<='z'||'A'<=c&&c<='Z'){
            sb.append(Character.toUpperCase(c));
        }else {
            return;
        }
        dfs(index+1,len,s);
        sb.deleteCharAt(sb.length()-1);
    }

}
