import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @author chen yu
 * @create 2021-11-28 23:29
 */
public class Solution438 {

    public static void main(String[] args) {
        String s="baa";
        String p="aa";
        Solution438 solution438 = new Solution438();
        List<Integer> anagrams = solution438.findAnagrams(s, p);
        for (Integer anagram : anagrams) {
            System.out.print(anagram+" ");
        }
    }
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map_target = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int left=0;
        int right=0;

        int len =s.length();

        for(char c :p.toCharArray()){
            map_target.put(c,map_target.getOrDefault(c,0)+1);
        }




        while(right<len){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            if(map_target.equals(map)){
                ans.add(left);
            }
            if(right>=p.length()-1){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if (/*right-left>=p.length()-1&&*/map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            right++;

        }
        return ans;
    }

}
