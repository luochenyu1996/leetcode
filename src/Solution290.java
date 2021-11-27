import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 290. 单词规律
 *
 * @author chen yu
 * @create 2021-11-24 19:58
 */
public class Solution290 {
    public static void main(String[] args) {
       String pattern= "abba";
       String s = "dog cat cat dog";
        Solution290 solution290 = new Solution290();
        boolean b = solution290.wordPattern(pattern, s);
        System.out.println(b);
    }

    public boolean wordPattern(String pattern, String s) {
        String[] strArray = s.split(" ");
        if(pattern.length()!=strArray.length){
            return false;
        }

        int len = strArray.length;
        HashMap<Character, String> strMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(!strMap.containsKey(pattern.charAt(i))){
                strMap.put(pattern.charAt(i),strArray[i]);
            }else {
                String outStr = strMap.get(pattern.charAt(i));
                if(!outStr.equals(strArray[i])){
                    return false;
                }
            }
        }
        Set<Character> characters = strMap.keySet();
        HashSet<String> set = new HashSet<>();
        for (Character character : characters) {
            set.add(strMap.get(character));
        }
        if (set.size()<strMap.size()){
            return false;
        }

        return true;
    }
}
