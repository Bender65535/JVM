package jvm;

class Parent3{
    static int a=3;
    static {
        System.out.println("parent3 static block");
    }

    static void doSomething(){
        System.out.println("do something");
    }
}

class Child3 extends Parent3{
    static {
        System.out.println("child3 static block");
    }
}

public class Test11 {
    public static void main(String[] args) {
        System.out.println(Child3.a);      //访问父类资源只表示对父类主动使用
        Child3.doSomething();
    }
}
