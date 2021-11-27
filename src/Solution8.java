/**
 * 8. 字符串转换整数 (atoi)
 *
 * @author chen yu
 * @create 2021-11-21 21:52
 */
public class Solution8 {
    public int myAtoi(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        //1.去除前导空格
        int index=0;
        while(index< length&&array[index]==' '){
            index++;
        }
        if(index==length){
            return 0;
        }

        //2.判断符号
        int sign=1;
        char firstChar = array[index];
        if(firstChar=='+'){
            index++;
        }else if(firstChar=='-'){
            index++;
            sign=-1;
        }

        int res=0;
        while(index<length){
            char currentChar = array[index];
            if(currentChar>'9'||currentChar<'0'){
                break;
            }

            if(res>Integer.MAX_VALUE/10||(res == Integer.MAX_VALUE / 10 && (currentChar - '0') > Integer.MAX_VALUE % 10)){
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currentChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res=res*10+sign*(currentChar-'0');
            index++;
        }
        return res;
    }
}
