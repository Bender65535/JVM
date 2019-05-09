package jvm;

import java.lang.reflect.Method;



public class Test20 {
    public static void main(String[] args) throws Exception {
        Test16 loader1=new Test16("loader1");
        Test16 loader2=new Test16("loader2");

        loader1.setPath("");

        Class<?> clazz1=loader1.loadClass("jvm.MyPerson");
        //由于loader1已经加载过了(在系统中有缓存),loader2不会再加载
        //不同命名空间加载的Class对象是不同的
        Class<?> clazz2=loader2.loadClass("jvm.MyPerson");

        System.out.println(clazz1==clazz2);

        Object object1=clazz1.newInstance();

        Object object2=clazz2.newInstance();

        Method method=clazz1.getMethod("setMyPerson",Object.class);  //表示该方法接受Object类型的参数
        method.invoke(object1,object2);      //在object1对象上调用该方法
    }
}
