package jvm;

public class Test17 {
    public static void main(String[] args) throws Exception {
        Test16 loader1=new Test16("loader1");

        Class<?> clazz=loader1.loadClass("jvm.MySample");
        System.out.println("class:"+clazz.hashCode());

        //如果注释掉该行,那么不会实例化MySample对象,即构造方法不会被调用
        Object object=clazz.newInstance();
    }
}
