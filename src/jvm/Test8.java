package jvm;

class FinalTest{
    public static final int x=3;

    static {
        System.out.println("final static block");
    }
}

public class Test8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}
