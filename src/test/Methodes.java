package test;

import java.util.function.Supplier;

public class Methodes {

    public void methode1(){
        System.out.println(" methode1  被调用");
    }
    public  void  methode2(){
        System.out.println(" methode2  被调用");
    }

    Supplier<String> methode3=()->{
        System.out.println(" methode2  被调用");
         return  "methode3 被调用";
    };

}
