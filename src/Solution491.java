import java.util.ArrayList;
import java.util.List;

/**
 * 491. 递增子序列
 *
 * @author chen yu
 * @create 2021-11-27 18:30
 */
public class Solution491 {
    ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();

    public static void main(String[] args) {
        Solution491 solution491 = new Solution491();
        int[] nums=  {4,6,7,7};
        solution491.findSubsequences(nums);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        dsf(nums,0,len,used,0);
        return  ans;

    }

    private void dsf(int[] nums,int depth,int len,boolean[] used,int begin){
        if(depth==len){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            if(used[i]||(path.size()>0&&nums[i]<path.get(path.size()-1))){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            dsf(nums,depth+1,len,used,begin+1);
            path.remove(path.size()-1);
            used[i]=false;
        }
        ans.add(new ArrayList<>(path));
    }
}
