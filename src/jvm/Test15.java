package jvm;

public class Test15 {
    public static void main(String[] args) {
        String[] string =new String[2];
        System.out.println(string.getClass().getClassLoader());

        System.out.println("---------------");

        Test15[] test15s=new Test15[2];
        System.out.println(test15s.getClass().getClassLoader());  //数组对应的class不是类加载器加载的,而是由jvm自动创建的

        System.out.println("----------------");

        int[] ints=new int[2];
        System.out.println(ints.getClass().getClassLoader());
        //与String的null不一样(启动类加载器用null表示),原生类型没有类加载器
    }
}
