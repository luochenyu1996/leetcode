import java.util.Arrays;

/**
 * @author chen yu
 * @create 2022-02-11 20:47
 */
public class testMD {
    public int playNum (int n, int m) {
         int count=n;
         int j=1;
         int countNum=0;
        int[] arr = new int[n + 1];
        Arrays.fill(arr,1);

        while (count>1){
            if(arr[j]!=0){
                countNum++;
                if(countNum==m){
                    count--;
                    arr[j]=0;
                    countNum=0;
                }
            }
            j++;
            if(j==n+1){
                j=1;
            }
        }
        for (int i = 1; i <= n; i++) {
            if(arr[i]==1){
                return i;
            }

        }
        return -1;
    }
}
