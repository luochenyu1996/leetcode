import java.util.ArrayDeque;

/**
 * 150. 逆波兰表达式求值
 *
 * @author chen yu
 * @create 2021-10-27 12:08
 */
public class Solution150 {

    public static void main(String[] args) {
        String[] array = {"4","13","5","/","+"};

        int res = evalRPN(array);
        System.out.println(res);

    }

    public static int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        for (String e : tokens) {
            if (isNumber(e)){
                stack.push(Integer.parseInt(e));
                continue;
            }
            Integer nums1 = stack.pop();
            Integer nums2 = stack.pop();
            switch (e) {
                case "+":
                    stack.push(nums1 + nums2);
                    break;
                case "-":
                    stack.push(nums1 - nums2);
                    break;
                case "*":
                    stack.push(nums1 * nums2);
                    break;
                case "/":
                    stack.push(nums2 / nums1);
                    break;
                default:
            }

        }
        return stack.pop();
    }

    private  static boolean isNumber(String str){
        return  !str.equals("/")&&!str.equals("*")&&!str.equals("+")&&!str.equals("-");

    }



}
