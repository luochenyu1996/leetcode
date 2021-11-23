import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author chen yu
 * @create 2021-11-01 09:02
 */
public class Solution238 {
    //使用前缀 后缀

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        //除自身外的前缀积
        int[] prefix_multi=new int[len];
        prefix_multi[0]=1;
        //除自身外的后缀积
        int[] suffix_multi=new int[len];
        suffix_multi[len-1]=1;

        int[] ans = new int[len];

        //向右遍历
        for (int i = 1; i < len; i++) {
            prefix_multi[i]=nums[i-1]*prefix_multi[i-1];
        }

        //向左遍历
        for (int j=len-2;j>0;j--){
            suffix_multi[j]=nums[j+1]*suffix_multi[j+1];
        }


        for(int index=0;index<len;index++){
            ans[index]=prefix_multi[index]*suffix_multi[index];
        }
        return ans;
    }

}
