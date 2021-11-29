import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 * @author chen yu
 * @create 2021-11-29 11:20
 */
public class Solution93 {

    ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {

        Solution93 solution93 = new Solution93();
        List<String> strings = solution93.restoreIpAddresses("25525511135");
        for (String string : strings) {
            System.out.println(string);
        }

    }

    ArrayList<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        dfs(s,s.length(),0,sb);
        return ans;
    }

    private void dfs(String s,int len,int index,StringBuilder sb){

        if(index==len){
            if(list.size()==4){
                ans.add(String.join(".",list));
            }
            return;
        }


        for (int i = index; i <=index+ 3; i++) {
            if (i>=len){
                break;
            }
            if(valid(s.substring(index,i+1))){
                list.add(s.substring(index,i+1));
                dfs(s,len,i+1,sb);
                list.remove(list.size()-1);

            }

        }
    }

    private  boolean valid(String s){
        if(Integer.parseInt(s)>255){
            return false;
        }
        if(Integer.parseInt(s)!=0&&s.charAt(0)=='0'){
            return false;
        }
        if(Integer.parseInt(s)==0&&s.length()>1){
            return false;
        }
        return true;
    }



}
