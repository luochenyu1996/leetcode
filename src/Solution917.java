import java.util.LinkedList;

/**
 * 917. 仅仅反转字母
 *
 * @author chen yu
 * @create 2022-02-23 10:45
 */
public class Solution917 {
    public String reverseOnlyLetters(String s) {
        int length = s.length();
        int index1=0;
        int index2=length-1;
        char[] array = s.toCharArray();

        while (index1<index2){
            if(isABC(array[index1])&&isABC(array[index2])){
                swap(array,index1,index2);
                index1++;
                index2--;
            }else if(!isABC(array[index1])){
                index1++;
            }else if(!isABC(array[index2])){
                index2--;
            }
        }
        return new String(array);
    }

    private void  swap(char[] array,int index1,int index2){
        char temp= array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }

    private boolean isABC(char c){
        if((c>='a'&& c<='z')||(c>='A'&& c<='Z')){
            return true;
        }
        return  false;
    }
}
