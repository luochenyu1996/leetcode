import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * @author chen yu
 * @create 2021-11-24 22:33
 */
public class Solution47 {
    public static void main(String[] args) {
        int nums[]={1,1,2};
        Solution47 solution47 = new Solution47();
        List<List<Integer>> permute = solution47.permuteUnique(nums);
        System.out.println(permute);
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        boolean[] flag = new boolean[len];
        dfs(nums,len,0,path,ans,flag);
        return  ans;


    }


    private void dfs(int[] nums,int len,int depth,List<Integer> path,List<List<Integer>> ans,boolean[] flag){
        if(depth==len){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(flag[i]){
                continue;
            }
            if(i>0&&nums[i]==nums[i-1]&&!flag[i-1]){
                continue;
            }

            path.add(nums[i]);
            flag[i]=true;
            dfs(nums,len,depth+1,path,ans,flag);
            flag[i]=false;
            path.remove(path.size()-1);
        }
    }
}
