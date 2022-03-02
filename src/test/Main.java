package test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

         String sort1="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36";
         String sort2="Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:108.0) Gecko/20100101 Firefox/108.0";
         String sort3="User-Agent:Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_6; en-US) AppleWebKit/533.20.25 (KHTML, like Gecko) Version/5.0.4 Safari/533.20.27";

        TestEnum testEnum0 = resolverBrowser(sort1);
        TestEnum testEnum1 = resolverBrowser(sort2);
        TestEnum testEnum2 = resolverBrowser(sort3);

        //System.out.println(testEnum0.toString());
        //assert testEnum1 != null;
        System.out.println(testEnum1.toString());
        System.out.println(testEnum2.toString());




    }


     public static   TestEnum resolverBrowser(String  userAgent){

         if(userAgent.contains(TestEnum.Chrome.getType())){

             String[] splitVersion = userAgent.substring(userAgent.indexOf("Chrome") + 7, userAgent.indexOf("Safari")).split("\\.");
             TestEnum.Chrome.setVersion(splitVersion[0]);
             return TestEnum.Chrome;
         }
          if(userAgent.contains(TestEnum.FireFox.getType())){
              String[] splitVersion = userAgent.substring(userAgent.indexOf("Firefox") + 8).split("\\.");
              TestEnum.FireFox.setVersion(splitVersion[0]);
             return  TestEnum.FireFox;
         }
          if(userAgent.contains(TestEnum.Safari.getType())){
              String[] splitVersion = userAgent.substring(userAgent.indexOf("Version") + 8, userAgent.indexOf("Safari")).split("\\.");
              TestEnum.Safari.setVersion(splitVersion[0]);
             return TestEnum.Safari;
          }
          return null;

     }
}
