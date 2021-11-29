import java.util.HashSet;
import java.util.Set;

/**
 * 1593. 拆分字符串使唯一子字符串的数目最大
 *  todo
 * @author chen yu
 * @create 2021-11-27 18:22
 */
public class Solution1593 {
    int maxSplitCount =1;
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        dfs(0,0,s,set);
        return  maxSplitCount;
    }

    private void dfs(int index, int splitCount, String s, Set<String> set){
        int len = s.length();
        if(index>=len) {
            maxSplitCount =Math.max(maxSplitCount,splitCount);
        }else{
            for (int i = index; i < len; i++) {
                String subStr = s.substring(index, i + 1);
                if(set.add(subStr)){
                    dfs(i+1,splitCount+1,s,set);
                    set.remove(subStr);
                }
            }
        }

    }

}
