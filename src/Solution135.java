import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 135. 分发糖果
 *
 * @author chen yu
 * @create 2021-12-29 12:32
 */
public class Solution135 {
    public static void main(String[] args) {
        int[] ratings= {1,2,87,87,87,2,1};
        Solution135 solution135 = new Solution135();
        int candy = solution135.candy(ratings);
        System.out.println(candy);
    }
    public int candy(int[] ratings) {


        int len = ratings.length;
        int[] leftArray = new int[len];
        int[] rightArray = new int[len];
        //每个孩子先给一个
        Arrays.fill(leftArray,1);
        Arrays.fill(rightArray,1);

        for (int i = 0; i < len-1; i++) {
            if(ratings[i+1]>ratings[i]){
                leftArray[i+1]=leftArray[i]+1;
            }
        }


        for (int i = len-1; i > 0; i--) {
            if(ratings[i-1]>ratings[i]){
                rightArray[i-1]=rightArray[i]+1;
            }
        }
        int ans=0;

        for (int i = 0; i < len; i++) {
            ans+=Math.max(leftArray[i],rightArray[i]);
        }
        return  ans;



    }
}
