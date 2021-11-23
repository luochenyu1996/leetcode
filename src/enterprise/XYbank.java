package enterprise;

/**
 * @author chen yu
 * @create 2021-11-14 12:23
 */
public class XYbank {

    public static void main(String[] args) {
        String str="A宸宇 0";
        int[] test = test(str);
        for (int i : test) {
            System.out.print(i);
        }
    }
    public static int[] test(String str1) {
        if (str1==null){
            return  new int[0];
        }
        int len=str1.length();
        int num_chinese=0;
        int num_english=0;
        int num_numbers=0;
        int num_space=0;
        for(int i=0;i<len;i++){
            if(str1.charAt(i)==' '){
              num_space++;
            }else if(str1.charAt(i)>='0'&&str1.charAt(i)<='9'){
                num_numbers++;
            }else if(str1.charAt(i)>='a'&&str1.charAt(i)<='z'||str1.charAt(i)>='A'&&str1.charAt(i)<='Z'){
                num_english++;
            }else {
                num_chinese++;
            }
        }
        return new int[]{num_chinese,num_english,num_numbers,num_space};
        }
}
