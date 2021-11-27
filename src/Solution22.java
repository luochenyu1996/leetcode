import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 回溯
 *
 * @author chen yu
 * @create 2021-11-27 12:00
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if(n==0){
            return  res;
        }
        dfs("", n, n, res);
        return res;
    }
    private void  dfs(String curStr,int left,int right,List<String> res){
        if(left==0&&right==0){
            res.add(curStr);
            return;
        }
        if(left>right){
            return;
        }
        if(left>0){
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }


    }
}
