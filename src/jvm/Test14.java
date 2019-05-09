package jvm;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class Test14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        //上下文加载器通常是启动应用的加载器
//        System.out.println(classLoader);

        String resourceName="jvm/Test7.class";

        Enumeration<URL> urls=classLoader.getResources(resourceName);

        while(urls.hasMoreElements()){
            URL url =urls.nextElement();
            System.out.println(url);
        }

    }
}
