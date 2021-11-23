import java.util.ArrayList;
import java.util.HashMap;

/**
 * 859. 亲密字符串
 *
 * @author chen yu
 * @create 2021-11-23 10:55
 */
public class Solution859 {
    public static void main(String[] args) {
        Solution859 solution859 = new Solution859();
        String s="ab";
        String goal="ba";
        boolean b = solution859.buddyStrings(s, goal);
        System.out.println(b);
    }

        public boolean buddyStrings(String s, String goal) {
            int index1=-1;
            int index2=-1;
            if (s.length() != goal.length()) {
                return false;
            }

            if(s.equals(goal)){
                int[] count = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    count[s.charAt(i)-'a']++;
                    if(count[s.charAt(i)-'a']>1){
                        return true;
                    }
                }
                return false;
            }else{

                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i)!=goal.charAt(i)){
                        if(index1==-1){
                            index1=i;
                        }else if (index2==-1){
                            index2=i;
                        }else {
                            return false;
                        }
                    }
                }

            }

            return  index2!=-1 &&s.charAt(index1)==goal.charAt(index2)&&s.charAt(index2)==goal.charAt(index1);



        }

}
