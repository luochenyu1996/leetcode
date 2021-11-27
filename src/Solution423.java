import java.util.Arrays;
import java.util.HashMap;

/**
 * 423. 从英文中重建数字
 *
 * @author chen yu
 * @create 2021-11-24 09:59
 */
public class Solution423 {


    public static void main(String[] args) {
        Solution423 solution423 = new Solution423();
        String fviefuro = solution423.originalDigits("zeroonetwothreefourfivesixseveneightnine");
        System.out.println(fviefuro);
    }


    public String originalDigits(String s) {

        StringBuilder  sb = new StringBuilder();
        String[] stringNum = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int []  findNum={0, 8, 6, 3, 2, 7, 5, 9, 4, 1};
        int[] counts = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            counts[s.charAt(i)-'a']++;
        }


        for (int i = 0; i <= 9; i++) {
            int k =Integer.MAX_VALUE;
            //找打特殊字符
            for(char c:stringNum[findNum[i]].toCharArray()){
                k=Math.min(k,counts[c-'a']);
            }
            //如果纯在这个特殊字符 那么所有的都减去一个
            for(char c:stringNum[findNum[i]].toCharArray()){
                counts[c - 'a'] =counts[c - 'a']- k;
            }
            while (k>0){
                sb.append(findNum[i]);
                k--;
            }

        }
        char[] array = sb.toString().toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);
    }


}
