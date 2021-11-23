import java.util.HashMap;
import java.util.Set;

/**
 * 137. 只出现一次的数字 II
 *
 * @author chen yu
 * @create 2021-11-12 22:29
 */
public class Solution137 {

    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        Set<Integer> keySet = map.keySet();

        for (Integer key : keySet) {
            if(map.get(key)==1){
                return key;
            }
        }

        return  -1;

    }
}
