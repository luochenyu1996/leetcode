import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * @author chen yu
 * @create 2021-11-27 16:18
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(n,k,0,ans,path);
        return  ans;
    }

    private  void dfs(int n,int k,int depth,List<List<Integer>> ans,List<Integer> path){
        if(depth==k){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(path.size()>0&& i<= path.get(path.size()-1)){
                continue;
            }
            path.add(i);
            dfs(n,k,depth+1,ans,path);
            path.remove(path.size()-1);
        }

    }
}
