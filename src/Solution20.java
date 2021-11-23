import java.util.ArrayDeque;

/**
 * 20. 有效的括号
 *
 * @author chen yu
 * @create 2021-10-27 11:39
 */
public class Solution20 {

    public boolean isValid(String s) {
        char[] array= s.toCharArray();
        ArrayDeque<Character>  stack= new ArrayDeque<Character>();
        for(char e :array){
            if(!stack.isEmpty()&& stack.peek()=='('&&e==')'){
                stack.pop();
            }else if(!stack.isEmpty()&&stack.peek()=='['&&e==']'){
                stack.pop();
            }else if(!stack.isEmpty()&&stack.peek()=='{'&&e=='}'){
                stack.pop();
            }else{
                stack.push(e);
            }
        }
        if(stack.size()==0){
            return true;
        }
        return false;
    }

}
