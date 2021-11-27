import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author chen yu
 * @create 2021-11-25 19:17
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        int len = candidates.length;
        dfs(candidates,target,0,len,path,ans);
        return ans;
    }

    private void dfs(int[] candidates,int target,int sum,int len,List<Integer> path,List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(path));
            return;
        }else if(sum>target){
                return;
        }
        for (int i = 0; i < len; i++) {
            if(path.size()>0&&candidates[i]<path.get(path.size()-1)){
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates,target,sum+candidates[i],len,path,ans);
            path.remove(path.size()-1);
        }

    }
}
