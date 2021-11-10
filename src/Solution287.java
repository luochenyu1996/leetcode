import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 287. 寻找重复数
 *
 * @author chen yu
 * @create 2021-10-23 21:26
 */
public class Solution287 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/287.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> integers = new ArrayList<>();
        while (scanner.hasNext()){
            integers.add(scanner.nextInt());
        }

        int[] nums= new int[integers.size()];

        for (int i=0;i<integers.size();i++){
            nums[i]=integers.get(i);
        }

        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);

    }

    public static int findDuplicate(int[] nums) {
        int fast=0;
        int slow=0;
        int ptr=0;

        while(true){
            fast=nums[nums[fast]];
            slow=nums[slow];
            if(slow==fast){
                break;
            }
        }

        while(true){
            if(ptr==slow) break;
            ptr=nums[ptr];
            slow=nums[slow];
        }

        return ptr;
    }

}
