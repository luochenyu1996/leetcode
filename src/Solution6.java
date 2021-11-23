import java.util.ArrayList;

/**
 * 6. Z 字形变换
 *
 * @author chen yu
 * @create 2021-11-21 20:47
 */
public class Solution6 {

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();

    }

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        ArrayList<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i=0;
        int flag=-1;

        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i==0||i==numRows-1){
                flag=-flag;
            }
            i=i+flag;
        }

        StringBuilder res=new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }


}
