import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * 回溯法的典型
 * @author chen yu
 * @create 2021-11-24 21:17
 */
public class Solution46 {



    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        ArrayList<Integer> path=  new ArrayList<Integer>();
        int len=nums.length;
        boolean[] used= new boolean[len];

        dfs(nums,len,0, path,ans,used);
        return ans;
    }

    private void dfs(int[] nums,int len,int depth,List<Integer> path,List<List<Integer>> ans,boolean[] used){
        if(depth==len){
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        for(int  i=0;i<len;i++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            dfs(nums,len,depth+1,path,ans,used);
            path.remove(path.size()-1);
            used[i]=false;
        }

    }






}
