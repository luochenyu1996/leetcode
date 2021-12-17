package enterprise.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 华为秋招第一题
 *
 * @author chen yu
 * @create 2021-12-01 18:48
 */
public class Solution01 {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] ss = s.split(",");
        int len = ss.length;
        int first=-1;
        int second=-1;
        int third=-1;

        boolean flag=true;

        if(len%3==0){
            first=0;
            second=first+len/3;
            third=second+len/3;

            while (third<len){
                if(ss[first].equals(ss[second])||ss[first].equals(ss[third])||ss[second].equals(ss[third])){
                    flag=false;
                    break;
                }else {
                    first++;
                    second++;
                    third++;
                }
            }

            if(flag==false){
                System.out.println("-1,-1");
            }else {
                System.out.println(first-len/3+","+(first+1));
            }

        }else {
            int diff=3-len%3;

            String[] nums = new String[len + diff];

            for (int i = 0; i < diff; i++) {
                nums[i]="0";
            }

            for (int i = diff; i < len+diff; i++) {
                nums[i]=ss[i-diff];
            }
            int le=nums.length;
            first=0;
            second=first+le/3;
            third=second+le/3;
            while (third<le){
                if(!nums[first].equals(nums[second])||!nums[first].equals(nums[third])||!nums[second].equals(nums[third])){
                    flag=false;
                    break;
                }else {
                    first++;
                    second++;
                    third++;
                }
            }
            if(flag==false){
                System.out.println("-1,-1");

            }else {
                System.out.print((first-le/3)+","+(first+1));

            }
        }

    }



}
