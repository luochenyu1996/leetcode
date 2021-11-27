import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *
 * 注意 ： curStr 是SringBuilder 的时候  递归之间传递的是引用对象只有一个 ；如果用的是string 类型，那么递归之间传递的是值，穿在多个对象
 *
 * @author chen yu
 * @create 2021-11-27 12:41
 */
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        ArrayList<String> ans = new ArrayList<>();
        int len = digits.length();
        if(len==0){
            return  ans;
        }
        dfs(digits,0,len,ans,new StringBuilder(),map);
        return ans;
    }

    private  void  dfs(String digits, int  index, int len, List<String> ans,StringBuilder curStr, Map<Integer, String> map){
        if(index==len){
            ans.add(curStr.toString());
            return;
        }
        char c = digits.charAt(index);
        String s = map.get(c-'0');

        for (int i = 0; i < s.length(); i++) {
            curStr=curStr.append(s.charAt(i));
            dfs(digits,index+1,len,ans,curStr,map);
            curStr.deleteCharAt(curStr.length()-1);
        }

    }
}
