import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 5. 最长回文子串

 * @author chen yu
 * @create 2021-11-17 11:58
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        int length = s.length();

        if(length<2){
            return s;
        }

        int maxLen=1;
        int begin=0;

        //dp[i][j] 表示 s[i....j]是否是回文数组
        boolean[][] dp = new boolean[length][length];

        //所有长度为1的字串均为回文串
        for(int i=0;i<length;++i){
            dp[i][i]=true;
        }
        char[] array = s.toCharArray();

        //枚举子字符串的长度
        for (int subLen = 2; subLen <= length; subLen++) {
            //枚举左边界
            for (int i = 0; i < length; i++) {
                //得到右边界
                int j=subLen+i-1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= length) {
                    break;
                }
                if(array[i]!=array[j]){
                    dp[i][j]=false;
                }else {
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }


            }
        }

        return s.substring(begin,begin+maxLen);
    }

}
