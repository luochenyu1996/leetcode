import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 *  解题的时候可以画一下递归树
 *
 * @author chen yu
 * @create 2021-11-27 12:00
 */
public class Solution22 {
    ArrayList<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> strings = solution22.generateParenthesis(2);
        for (String string : strings) {
            System.out.println(string);
        }
    }


    public List<String> generateParenthesis(int n) {
        dfs(n, 0,0);
        return res;
    }

    private void dfs(int n,int left,int right){
        if(right==n&&left==n){
            res.add(sb.toString());
            return;
        }


        //这个条件在不同情况下可以在不同的位置进行放置
        if(left>n||right>n||right>left){
            return;
        }

        sb.append("(");

        dfs(n,left+1,right);
        sb.deleteCharAt(sb.length()-1);

        sb.append(")");
        dfs(n,left,right+1);
        sb.deleteCharAt(sb.length()-1);
    }

}
