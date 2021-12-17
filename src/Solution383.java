import java.util.HashMap;
import java.util.HashSet;

/**
 * 383. 赎金信
 *
 * @author chen yu
 * @create 2021-12-04 22:30
 */
public class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        int mgLen = magazine.length();
        int rnLen = ransomNote.length();


        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < mgLen; i++) {
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }

        for (int i = 0; i < rnLen; i++) {
           if(map.containsKey(ransomNote.charAt(i))){
               Integer value = map.get(ransomNote.charAt(i));
               if(value>0){
                   map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
               }else {
                   return false;
               }
           }else {
               return false;
           }
        }

        return true;
    }

}
