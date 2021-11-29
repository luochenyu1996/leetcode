import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * @author chen yu
 * @create 2021-11-27 18:10
 */
public class Solution216 {
    List<List<Integer>> ans= new ArrayList<List<Integer>>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] used = new boolean[10];
        dfs(k,0,0,n,used);
        return ans;
    }

    private void dfs(int k,int depth,int sum,int n,boolean[] used){
        if(sum==n&&k==depth){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(k==depth){
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if(used[i]||(path.size()>0&&i<path.get(path.size()-1))){
                continue;
            }
            path.add(i);
            used[i]=true;
            dfs(k,depth+1,sum+i,n,used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}
