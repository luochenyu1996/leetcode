/**
 * 520
 *
 * @author chen yu
 * @create 2021-11-13 10:00
 */
public class Solution520 {
    public static void main(String[] args) {
        System.out.println('a'-0);
        System.out.println('A'-0);

    }

    public boolean detectCapitalUse(String word) {
        int bigCount=0;

        int len = word.length();
        for (int i = 0; i < len; i++) {
            if(word.charAt(i)>='A'&&word.charAt(i)<='Z'){
                bigCount++;
            }
        }

        if (bigCount==0){
            return true;
        }else if(bigCount==len){
            return true;
        }else if (bigCount==1&&word.charAt(0)>='A'&&word.charAt(0)<='Z'&&len>1){
            return true;
        }
        return false;

    }
}
