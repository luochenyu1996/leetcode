import java.util.ArrayList;

/**
 * @author chen yu
 * @create 2021-11-09 14:51
 */
public class SolutionMD {
    public ArrayList<Integer> findPrimeNumber (int m, int n) {
        // write code here
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=m;i<n;i++){
            int flag=0;
            for (int j=2;j<i;j++){
                if(i%j==0){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                ans.add(i);
            }
        }
        return ans;
    }

}
