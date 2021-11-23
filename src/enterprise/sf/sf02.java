package enterprise.sf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author chen yu
 * @create 2021-10-24 21:32
 */
public class sf02 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\MyCode\\leetcode\\src\\enterprise\\sf02.txt");
        Scanner sc = new Scanner(file);
        int T = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        ArrayList<String> list = new ArrayList<>();
        while (T-->0){
            int n = sc.nextInt();
                        while (n-->0){
                String name = sc.next();
                int score = sc.nextInt();
                map.put(name,map.getOrDefault(name,0)+score);
                if (map.get(name)>max){
                    max= map.get(name);
                    list.clear();
                    list.add(name);
                }else if(map.get(name)==max){
                    list.add(name);
                }
                System.out.println(list.get(0));
            }
        }
    }
}
