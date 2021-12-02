import java.util.*;

/**
 * 93. 复原 IP 地址
 *
 * @author chen yu
 * @create 2021-11-29 11:20
 */
public class Solution93 {

    ArrayList<String> ans = new ArrayList<>();

    ArrayList<String > list =  new ArrayList<String>();

    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        List<String> strings = solution93.restoreIpAddresses("25525511135");
        for (String string : strings) {
            System.out.println(string);
        }
    }


    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, s.length());
        return ans;
    }

    private void dfs(String s, int index, int len) {
        if (index == len&&ans.size()==4) {
            ans.add(String.join(".",list));
            return;
        }
        if(index < len&&list.size()==4){
            return;
        }


        for (int i = 0; i < 3; i++) {
            if(index+i>=len){
                break;
            }
            String substring = s.substring(index, index + i + 1);
            if (valid(substring)) {
                list.add(substring);
                dfs(s, i +1+index, len);
                list.remove(list.size()-1);
            }

        }

    }

    private boolean valid(String str){
        if(Integer.parseInt(str)>255){
            return false;
        }
        if(Integer.parseInt(str)!=0&&str.charAt(0)=='0'){
            return  false;
        }
        if(Integer.parseInt(str)==0&&str.length()>1){
            return false;
        }
        return true;

    }

}






