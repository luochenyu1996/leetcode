import java.util.*;

/**
 * 264. 丑数 II
 *
 * @author chen yu
 * @create 2022/1/14
 */
public class Solution264 {
    public int nthUglyNumber(int n) {
        //丑数 是如何产生的
        int[] array = new int[n + 1];
        array[1]=1;
        for (int i = 2, index2=1,index3=1,index5=1 ; i <=n; i++) {
            int a=2*array[index2];
            int b=3*array[index3];
            int c=5*array[index5];
            int min = Math.min(a, Math.min(b, c));
            if(min==a){
                index2++;
            }
            if(min==b){
                index3++;
            }
            if(min==c){
                index5++;
            }
            array[i]=min;
        }
        return array[n];

    }
}
