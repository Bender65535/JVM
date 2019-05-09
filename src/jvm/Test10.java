package jvm;

class Parent2{
    static int a=3;
    static{
        System.out.println("parent static block");
    }
}
class Child2 extends Parent2{
    static int b=4;
    static {
        System.out.println("child2 static block ");
    }
}

public class Test10 {
    static{
        System.out.println("test10 static block");
    }
    public static void main(String[] args) {
        Parent2 parent2;   //声明引用并不是对类的主动使用

        System.out.println("---------------------");

        parent2=new Parent2();  //生成实例导致静态代码块被调用

        System.out.println("---------------------");

        System.out.println(parent2.a);

        System.out.println("---------------------");

        System.out.println(Child2.b);
    }
}
