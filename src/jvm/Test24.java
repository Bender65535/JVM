package jvm;

/**
 * 当前类加载器(Current Classloader):
 *
 * 每个类都会使用自己的类加载器(即加载自身的类加载器)来去加载其他类(指的是所依赖的类)
 * 如果ClassX引用了ClassY,那么ClassX的类加载器就会去加载ClassY(前提是ClassY尚未被加载)
 *
 * 线程上下文类加载器(Context Classloader):
 *
 * 线程上下文类加载器是从JDK1.2开始引入的,类Thread中的getContextClassLoader()与setContextClassLoader()
 * 分别用来获取和设置上下文类加载器
 *
 * 如果没有通过setContextClassLoader()进行设置的话,线程将继承其父线程的上下文类加载器.
 * Java应用运行时的初始线程的上下文类加载器是系统类加载器.在线程中运行的代码可以通过类加载器来加载类与资源
 *
 * 线程上下文类加载器的重要性:
 *
 * SPI(Service Provider Interface)服务提供者接口
 *
 * 父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的classloader加载的类
 * 这就改变了父ClassLoader不能使用子ClassLoader或是其他没有直接父子关系的ClassLoader加载的情况,即改变了
 * 双亲委托模型
 *
 * 在双亲委托模型下,类加载是由上至下的,即下层的类加载器会委托上层进行加载.但是对于SPI来说,有些接口是java核心库所提供的,
 * 而java核心库是由启动类加载器来加载的,而这些接口的实现却来自于不同的jar包(厂商提供),java的启动类加载器是不会加载其他
 * 来源的jar包,这样传统的双亲委托模型就无法满足SPI的要求.而通过给当前线程设置上下文类加载器,就可以由设置的上下文来加载器
 * 来实现对于接口实现类的加载
 */

public class Test24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
