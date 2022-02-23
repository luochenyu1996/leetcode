import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * @author chen yu
 * @create 2021-11-26 10:59
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int len=candidates.length;
        boolean[] flag = new boolean[len];
        dfs(candidates,target,0,len,path,ans,flag);
        return ans;

    }


    private  void dfs(int[] candidates ,int target,int sum,int len,List<Integer> path,List<List<Integer>>  ans,boolean[] flag){
        if(target==sum){
            ans.add(new ArrayList<>(path));
            return;
        }else if(sum>target){
            return;
        }
        for (int i = 0; i < len; i++) {
            //减枝条件
            //1、不往小的走
            //2、用过的不用
            //3、等于时候不再继续用
            if(flag[i]||(path.size()>0&&candidates[i]<path.get(path.size()-1))||(i>0&&candidates[i]==candidates[i-1]&&!flag[i-1])){
                continue;
            }
            path.add(candidates[i]);
            flag[i]=true;
            dfs(candidates,target,sum+candidates[i],len,path,ans,flag);
            path.remove(path.size()-1);
            flag[i]=false;
        }
    }


}
