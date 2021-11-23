/**
 * @author chen yu
 * @create 2021-11-05 15:38
 */
public class test {
    public static void main(String[] args) {
        int dd = dd(1);

    }



    private  static int dd(int num){


        try {
            System.out.println(num);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        return 2;

    }

}
