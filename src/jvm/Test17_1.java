package jvm;

/**
 * 关于命名空间的重要说明:
 * 1.子加载器所加载的类能够访问到父加载器所加载的类
 * 2.父加载器所加载的类无法访问到子加载器所加载的类
 */


public class Test17_1 {
    public static void main(String[] args) throws Exception {
        Test16 loader1=new Test16("loader1");

        Class<?> clazz=loader1.loadClass("jvm.MySample");
        System.out.println("class:"+clazz.hashCode());

        //如果注释掉该行,那么不会实例化MySample对象,即构造方法不会被调用
        Object object=clazz.newInstance();
    }
}
