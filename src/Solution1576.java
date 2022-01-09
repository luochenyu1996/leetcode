/**
 * 1576. 替换所有的问号
 *
 * @author chen yu
 * @create 2022-01-05 10:25
 */
public class Solution1576 {

    public static void main(String[] args) {

    }

    public String modifyString(String s) {

        char[] array = s.toCharArray();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < 3 && array[i] == '?'; c++) {
                boolean ok = true;
                if (i - 1 >= 0 && array[i - 1] == c + 'a'){
                    ok = false;
                }
                if (i + 1 < n && array[i + 1] == c + 'a'){
                    ok = false;
                }
                if (ok){
                    array[i] = (char) (c + 'a');
                }
            }
        }
        return String.valueOf(array);
    }


}
