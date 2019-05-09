package jvm;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载器的一般使用模式(获取 - 使用 - 还原)
 * //获取
 * ClassLoader classLoader =Thread.currentThread().getContextClassLoader();
 *
 * try{
 *      //替换
 *     Thread.currentThread().getContextClassLoader(targetTccl);
 *     //使用
 *     myMethod();  //获取targetTccl
 * }finally{
 *      //还原
 *     Thread.currentThread().setContextClassLoader(classLoader);
 * }
 *
 * myMethod里面则调用了Thread.currentThread().getContextClassLoader(),来获取线程的上下文类加载器做某些事情
 *
 * 如果一个类由类加载器A加载,那么这个类的依赖也是由相同的类加载器加载的(如果依赖类之前没有被加载过的话)
 *
 * ContextClassLoader的作用就是为了破坏Java的类加载委托机制
 *
 * 当高层提供了统一的接口让底层去实现,同时又要在高层区加载(或实例化)低层类时,就必须要通过线程上下文类加载器来帮助高层的ClassLoader
 * 找到并加载该类
 */

public class Test26 {
    public static void main(String[] args) {
        //java.util是核心库的一部分,由启动类加载器加载
        ServiceLoader<Driver> loader=ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator=loader.iterator();

        while(iterator.hasNext()){
            Driver driver=iterator.next();

            System.out.println("driver:" + driver.getClass()+",loader:"+driver.getClass().getClassLoader());
        }
        System.out.println("当前线程上下文加载器:"+Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器:"+ServiceLoader.class.getClassLoader());
    }
}
