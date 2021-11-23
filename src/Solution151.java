import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 *
 * @author chen yu
 * @create 2021-11-11 15:36
 */
public class Solution151 {

    public static void main(String[] args) {


    }

    public String reverseWords(String s) {
        String s_trim = s.trim();
        List<String> strings = Arrays.asList(s_trim.split("\\s+"));
        Collections.reverse(strings);
        String join = String.join(" ", strings);
        return join;
    }
}
