package jvm;

public class Test6 {
    public static void main(String[] args) {
        //调用静态方法表示对该类的主动使用,该类进入初始化
        Singleton singleton =Singleton.getInstance();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);
    }
}
class Singleton{
    public static int counter1=1;


    //加载阶段初始值为null,进入真正的初始化状态后赋值,执行构造函数
    private static Singleton singleton =new Singleton();
    //因此构造函数在准备阶段没有执行
    private Singleton(){
        counter1++;
        counter2++;
    }

    public static int counter2=0;


    public static Singleton getInstance(){
        return singleton;
    }
}
