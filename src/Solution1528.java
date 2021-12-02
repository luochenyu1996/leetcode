/**
 * 1528. 重新排列字符串
 *
 * @author chen yu
 * @create 2021-11-29 18:11
 */
public class Solution1528 {
    public static void main(String[] args) {
        Solution1528 solution1528 = new Solution1528();
        String s = "aiohn";
        int[] indices = {3, 1, 4, 2, 0};

        String s1 = solution1528.restoreString(s, indices);
        System.out.println(s1);

    }

    public String restoreString(String s, int[] indices) {
        int len = s.length();
        char[] tempArray = new char[len];

        for (int i = 0; i < len; i++) {
            tempArray[indices[i]] = s.charAt(i);
        }
        return new String(tempArray);

    }
}


