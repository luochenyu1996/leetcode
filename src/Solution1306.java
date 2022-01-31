import java.util.HashSet;

/**
 * 1306. 跳跃游戏 III
 *
 * @author chen yu
 * @create 2022/1/21
 */
public class Solution1306 {
    int len;
    public boolean canReach(int[] arr, int start) {
        len = arr.length;
        boolean[] flags = new boolean[len];
        return dfs(arr,start,flags);
    }


    private boolean  dfs(int[] arr ,int start,boolean[] flags){
        if(start>=len||start<0){

            return false;
        }
        if(arr[start]==0){
            return true;
        }

        //这里还要加一个去环路操作
        if (flags[start]){
            return false;
        }else {
            flags[start]=true;
        }
        boolean flag1 = dfs(arr, start + arr[start],flags);
        boolean flag2 = dfs(arr, start - arr[start],flags);
        flags[start]=false;
        return  flag1||flag2;
    }

}
