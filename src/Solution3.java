import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 *
 * @author chen yu
 * @create 2021-11-17 11:02
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int ans = solution3.lengthOfLongestSubstring("aab");
        System.out.println(ans);


    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len=s.length();
        int left=0;
        int ans=0;
        for(int right=0;right<len;++right){
           map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
           while(map.get(s.charAt(right))>=2){
               map.put(s.charAt(left),map.get(s.charAt(left))-1);
               left++;
           }
           ans=Math.max(ans,right-left+1);

        }
        return ans;
    }
}
