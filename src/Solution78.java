import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. 子集
 *
 * @author chen yu
 * @create 2021-11-26 11:22
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        int len = nums.length;
        ans.add(new ArrayList<>());
        dfs(nums,len,0,ans,path);
        return  ans;

    }

    private void dfs(int[] nums,int len,int depth,List<List<Integer>> ans, List<Integer> path){
        ans.add(new ArrayList<>(path));
        if(depth==len){
            return;
        }
        for (int i = 0; i < len; i++) {
            //这里 <=  也可以使用used[] 标记数组
            if(path.size()>0&&nums[i]<=path.get(path.size()-1)){
                continue;
            }
            path.add(nums[i]);
           //  ans.add(new ArrayList<>(path));  调整到上面的位置
            dfs(nums,len,depth+1,ans,path);
            path.remove(path.size()-1);
        }
    }
}
