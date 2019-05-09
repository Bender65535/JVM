package jvm;

/**
 * 对于数组实例来说,其类型是由JVM在运行期动态生成的,表示为class [Ljvm.MyParent4;
 * 这种形式.动态生成的类型,其父类型就是Object.
 *
 * 对于数组来说,JavaDoc经常将构成数组的元素为Component,实际上就是将数组降低一个维度后的类型
 *
 * 助记符:
 *      anewarray:表示创建一个引用类型的(如类,接口,数组)数组,并将其引用值压入栈顶
 *      newarray:表示创建一个指定的原始类型(如int,float,char等)的数组,并将其引用压入栈顶
 */
public class Test4 {
    public static void main(String[] args) {
        /**
         * 静态代码块只被执行一次
         */
//        MyParent4 myParent4 = new MyParent4();
//        System.out.println("=============");
//        MyParent4 myParent5 = new MyParent4();

        /**
         * 数组不会导致类的主动使用
         */
        MyParent4[] myParent4s=new MyParent4[1];
        System.out.println(myParent4s.getClass());
        //class [Ljvm.MyParent4;是虚拟机在运行期自动创建的类型(类似动态代理)

        int[] ints=new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

    }
}

class MyParent4 {
    static {
        System.out.println("static block");
    }
}