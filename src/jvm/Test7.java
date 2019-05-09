package jvm;

public class Test7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz=Class.forName("java.lang.String");
        //返回为null表示由启动类或根类加载器加载
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 =Class.forName("jvm.C");
        //由应用类加载器加载(主要加载工程中的class文件)
        System.out.println(clazz2.getClassLoader());
    }
}
class C{

}