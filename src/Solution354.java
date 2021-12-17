import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题
 *
 * @author chen yu
 * @create 2021-12-08 16:40
 */
public class Solution354 {

    public static void main(String[] args) {
        int[][] envelopes={{5,4},{6,4},{6,7},{2,3}};

        Solution354 solution354 = new Solution354();
        int res = solution354.maxEnvelopes(envelopes);
        System.out.println(res);
    }

    public int maxEnvelopes(int[][] envelopes) {
        int len= envelopes.length;
        //对数组进行排序
        Arrays.sort(envelopes,Comparator.comparingInt(o->o[0]));
        //以第 i 个数结尾 ，且包含 i  的最大信封数
        int [] dp=new int[len];
        Arrays.fill(dp,1);
        int ans=dp[0];
        for(int i =1;i<len;i++){
            for(int j =0;j<i;++j){
                if(isBig(envelopes[i],envelopes[j])){
                    dp[i]= Math.max(dp[i],dp[j]+1) ;
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }

    private boolean  isBig(int[] a , int[] b){
        if(a[0]>b[0]&&a[1]>b[1]){
            return true;
        }else{
            return false;
        }
    }
}
