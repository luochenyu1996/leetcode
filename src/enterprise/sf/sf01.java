package enterprise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author chen yu
 * @create 2021-10-24 21:07
 */
public class sf01 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\MyCode\\leetcode\\src\\enterprise\\sf01.txt");
        Scanner sc = new Scanner(file);
        int line = sc.nextInt();
        while (line-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int temp1=(int)Math.ceil((double) n/a);
            int temp2=(int)Math.ceil((double) m/a);
            System.out.println(temp1*temp2);
        }
    }


}
