import java.util.ArrayList;
import java.util.List;

/**
 * 507. 完美数
 *
 * @author chen yu
 * @create 2021-12-31 09:37
 */
public class Solution507 {
    public boolean checkPerfectNumber(int num) {
        List<Integer> list= new ArrayList<Integer>();
        int  len=num;
        for(int i=1;i<len;i++){
            if(num%i==0){
                list.add(i);
            }
        }
       int sum=0;
        for (Integer integer : list) {
            sum+=integer;
        }
        return sum==num;

    }
}
