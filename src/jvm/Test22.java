package jvm;

public class Test22 {

    static{
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {
        System.out.println(Test22.class.getClassLoader());

        System.out.println(Test2.class.getClassLoader());
    }
}
