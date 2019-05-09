package jvm;

class CL{
    static {
        System.out.println("class CL");
    }
}

/**
 * 调用ClassLoader类的loadClass方法加载一个类,并不是对类的主动使用,不会导致类的初始化
 *
 * 加载并不意味着初始化
 */

public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();  //获取系统类加载器

        Class<?> clazz = loader.loadClass("jvm.CL");

        System.out.println(clazz);

        System.out.println("-------------");

        clazz=Class.forName("jvm.CL");   //反射导致类的初始化

        System.out.println(clazz);
    }
}
