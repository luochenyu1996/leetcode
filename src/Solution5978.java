import java.util.*;
import java.util.logging.Handler;

/**
 * 5978. 统计追加字母可以获得的单词数
 *
 * @author chen yu
 * @create 2022-01-09 11:22
 */
public class Solution5978 {
    public static void main(String[] args) {
        String[] startWords = {"ant", "act", "tack"};
        String[] targetWords = {"tack", "act", "acti"};
        Solution5978 solution5978 = new Solution5978();
        int count = solution5978.wordCount(startWords, targetWords);
        System.out.println(count);
    }


    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> set = new HashSet<>();
        for (String startWord : startWords) {
            char[] array = startWord.toCharArray();
            Arrays.sort(array);
            set.add(new String(array));
        }

        int ans=0;
        for (String targetWord : targetWords) {
            char[] array = targetWord.toCharArray();
            Arrays.sort(array);
            int length = array.length;
            String tempStr = new String(array);

            for (int i = 0; i < length; i++) {
                String subStr=tempStr.substring(0,i)+tempStr.substring(i+1,length);
                if(set.contains(subStr)){
                  ans++;
                  break;
                }
            }
        }
        return ans;
    }


}
