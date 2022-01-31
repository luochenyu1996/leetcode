/**
 * 1332. 删除回文子序列
 * 有点脑静急转弯了
 * @author chen yu
 * @create 2022/1/22
 */
public class Solution1332 {
    public int removePalindromeSub(String s) {

        int len = s.length();

        int left=0;
        int right=len-1;

        while (right>left){
            if(s.charAt(right)!=s.charAt(left)){
                return 2;
            }
            right--;
            left++;
        }
        return 1;

    }
}
