import org.omg.CORBA.MARSHAL;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 1763. 最长的美好子字符串
 *
 * @author chen yu
 * @create 2022-02-01 00:09
 */
public class Solution1763 {


    public static void main(String[] args) {
        Solution1763 solution1763 = new Solution1763();
        String res = solution1763.longestNiceSubstring("aAa");
        System.out.println(res);
    }


    public String longestNiceSubstring(String s) {

        int n = s.length();
        int maxPos = 0;
        int maxLen = 0;
        for (int i = 0; i < n; ++i) {
            int lower = 0;
            int upper = 0;
            for (int j = i; j < n; ++j) {
                if (Character.isLowerCase(s.charAt(j))) {
                    lower|=1 << (s.charAt(j) - 'a');


                } else {
                    upper |= 1 << (s.charAt(j) - 'A');

                }
                if (lower == upper && j - i + 1 > maxLen) {
                    maxPos = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(maxPos, maxPos + maxLen);
    }


}
