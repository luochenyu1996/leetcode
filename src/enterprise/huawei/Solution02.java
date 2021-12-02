package enterprise.huawei;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 华为秋招第二题
 *
 * @author chen yu
 * @create 2021-12-01 18:48
 */
public class Solution02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int len = nums.length;

        if(len<3){
            System.out.println(0);
        }
        Arrays.sort(nums);
        long temp=0;
        HashSet<Integer> set = new HashSet<>();
        int res =0;
        for (int i = 1; i < n-1; i++) {
            if(i>1&&nums[i]==nums[i-1]){
                continue;
            }
            set.add(nums[i-1]);

            for (int j = i+1; j < n; j++) {
                if(nums[j]==nums[j-1]){
                    continue;
                }
                temp= (long) (nums[j] + nums[i]) *(nums[j]-nums[i]);
                double sqrt = Math.sqrt(temp);
                if(set.contains(((int)sqrt))){
                    res++;

                }
            }
        }
        System.out.println(res);
    }
}
