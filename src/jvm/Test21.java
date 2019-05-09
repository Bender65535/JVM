package jvm;

import java.lang.reflect.Method;

/**
 * 类加载器的双亲委托模型的好处:
 *
 * 1.可以确保java核心库的类型安全:所有的java应用都至少会引用java.lang.Object类,也就是说在运行期,java.lang.Object这个类
 * 会被加载到java虚拟机中;如果这个加载过程是由java应用自己的类加载器所完成的,那么很可能就会在JVM中存在多个版本的
 * java.lang.Object类,而且这些类之间还是不兼容,相互不可见的(正是命名空间发挥着作用)
 * 借助于双亲委托机制,java核心类库中的类加载工作都是启动类加载器来统一完成,从而确保了java应用所使用的都是同一个版本的
 * java核心类库,他们之间是相互兼容的.
 *
 * 2.可以确保java核心类库所提供的类不会被自定义的类所替代.
 *
 * 3.不同的类加载器可以为相同名称(binary name)的类创建额外的命名空间.相同名称的类可以并存在java虚拟机中,只需要不同的
 * 类加载器来加载他们即可.不同类加载器所加载的类之间是不兼容的.这就相当于在java虚拟机内部创建了一个又一个相互隔离的java
 * 类空间,这类技术在很多框架中都得到了实际应用
 */

public class Test21 {
    public static void main(String[] args) throws Exception {
        Test16 loader1=new Test16("loader1");
        Test16 loader2=new Test16("loader2");

        Class<?> clazz1=loader1.loadClass("jvm.MyPerson");
        //由于loader1已经加载过了(在系统中有缓存),loader2不会再加载
        Class<?> clazz2=loader2.loadClass("jvm.MyPerson");

        System.out.println(clazz1==clazz2);

        Object object1=clazz1.newInstance();
        Object object2=clazz2.newInstance();

        Method method=clazz1.getMethod("setMyPerson",Object.class);  //表示该方法接受Object类型的参数
        method.invoke(object1,object2);      //在object1对象上调用该方法
    }
}
