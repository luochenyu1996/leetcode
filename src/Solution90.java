import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 *
 * @author chen yu
 * @create 2021-11-27 15:20
 */
public class Solution90 {
    public static void main(String[] args) {
        int [] nums={1,2,2};
        Solution90 solution90 = new Solution90();
        List<List<Integer>> lists = solution90.subsetsWithDup(nums);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(nums,len,0,ans,path,used);
        return ans;
    }
    private void dfs(int[] nums,int len,int depth,List<List<Integer>> ans,List<Integer> path,boolean[] used){
        if(len==depth){
            ans.add(new ArrayList<>(path));
            return;
        }
        ans.add(new ArrayList<>(path));
        for (int i = 0; i < len; i++) {

            if(used[i]||(i>0&&nums[i]==nums[i-1]&&!used[i-1])||(path.size()>0&&nums[i]<path.get(path.size()-1))){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            dfs(nums,len,depth+1,ans,path,used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }


}
