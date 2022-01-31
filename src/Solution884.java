import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * 884. 两句话中的不常见单词
 *
 * @author chen yu
 * @create 2022-01-30 23:01
 */
public class Solution884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Array = s1.split(" ");
        String[] s2Array = s2.split(" ");

        HashMap<String, Integer> map = new HashMap<>();

        for (String e1 : s1Array) {
            if(!Objects.equals(e1, " ")){
                map.put(e1,map.getOrDefault(e1,0)+1);
            }
        }
        for (String e2 : s2Array) {
            if(!Objects.equals(e2, " ")){
                map.put(e2,map.getOrDefault(e2,0)+1);
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if(map.get(key)==1){
                ans.add(key);
            }
        }
      return   ans.toArray(new String[0]);
    }

}
