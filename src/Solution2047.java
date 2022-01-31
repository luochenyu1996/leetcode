/**
 * 2047. 句子中的有效单词数
 *
 * @author chen yu
 * @create 2022-01-27 23:56
 */
public class Solution2047 {

    public static void main(String[] args) {
        Solution2047 solution2047 = new Solution2047();
        int i = solution2047.countValidWords("b-,");
        System.out.println(i);
    }

    public int countValidWords(String sentence) {
        int count=0;
        String[] array = sentence.split(" ");
        for (String ele : array) {

            int length = ele.length();
            if(length==0) continue;
            int i=0;
            int countOf_=0;

            for (; i < length; i++) {

                if((ele.charAt(i)=='!'||ele.charAt(i)==','||ele.charAt(i)=='.')&&i!=length-1){
                    break;
                }
                if (ele.charAt(i)<='9'&&ele.charAt(i)>='0'){
                    break;
                }
                if(ele.charAt(i)=='-'&&(i==0||i==length-1)){
                    break;
                }
                if ((i!=0&&i!=length-1)&&(ele.charAt(i)=='-')&&((ele.charAt(i-1)>'z'||ele.charAt(i-1)<'a')||(ele.charAt(i+1)>'z'||ele.charAt(i+1)<'a'))){
                    break;
                }
                if(ele.charAt(i)=='-') {
                    countOf_++;
                }

            }
            if(i==length&&countOf_<2){
                count++;
            }



        }
        return count;
    }
}
