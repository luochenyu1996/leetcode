import java.lang.reflect.Array;
import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author chen yu
 * @create 2022-01-07 17:58
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        String[] strsCopy = Arrays.copyOf(strs, len);
        for (int i = 0; i < len; i++) {
            char[] array = strsCopy[i].toCharArray();
            Arrays.sort(array);
            String s = new String(array);
            strsCopy[i]=s;
            if(map.containsKey(s)){
                ArrayList<String> list = map.get(s);
                list.add(strs[i]);
            }else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s,list);
            }
        }

        ArrayList<List<String>> ans = new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String string : strings) {
            ans.add(map.get(string));

        }
        return ans;

    }
}
