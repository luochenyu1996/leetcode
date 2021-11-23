/**
 * 318. 最大单词长度乘积
 *
 * @author chen yu
 * @create 2021-11-17 10:25
 */
public class Solution318 {

    public static void main(String[] args) {
        Solution318 solution318 = new Solution318();
        int res = solution318.maxProduct(new String[]{"abc"});

        System.out.println(res);
    }

    /**
     *   a b c d e f g 。。。 的标志位 按照这个大小顺序
     *
     */
    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        int length = words.length;

        //转换成bit数组
        for(int i=0;i<length;i++){
            char[] charArray = words[i].toCharArray();
            for(int j=0;j<charArray.length;++j){
                int temp = 1 << charArray[j] - 'a';
                bits[i]=bits[i]|temp ;
            }
        }

        //利用双重循环找到最大值
        int max=0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if((bits[i]&bits[j])==0){
                    max=Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}
