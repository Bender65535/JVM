package jvm;

import java.io.*;

public class Test16 extends ClassLoader {
    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class";

    public Test16(String classLoaderName) {
        //将系统加载器当做该类加载器的父加载器(根据双亲委托机制,该加载器不会加载,而是先交给它的父类加载器)
        this.classLoaderName = classLoaderName;
    }

    public Test16(ClassLoader parent, String classLoaderName) {
        super(parent);  //显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    //将字节数组转换为class类实例
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        //并不会被输出,说明该方法没被调用
        System.out.println("findClass invoked:" + className);
        System.out.println("class loader name:" + this.classLoaderName);
        byte[] data = this.loadClassData(className);
        //根据字节数组构造该类
        return this.defineClass(className, data, 0, data.length); //className为数据名,data为文件本身
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;

        className = className.replace(".", "/");

        ByteArrayOutputStream baos = null;

//        this.classLoaderName = this.classLoaderName.replace(".", "/");

        try {
            is = new FileInputStream(new File(this.path + className + this.fileExtension));

            baos = new ByteArrayOutputStream();

            int ch = 0;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return data;
    }


    public static void main(String[] args) throws Exception {
        Test16 loader = new Test16("loader");
        //当地址不在ClassPath中时,并且ClassPath中没有该类文件时,由自定义加载器加载
        loader.setPath("E:\\idea_workspace\\JVMProject\\out\\production\\JVMProject\\jvm\\");
        Class<?> clazz = loader.loadClass("jvm.Test2");
        System.out.println("class:" + clazz.hashCode());
        Object object = clazz.newInstance();

        System.out.println(object);

        System.out.println();

        /**
         * loader和loader2为两个不同类加载器,是不同的命名空间,因此可以将相同的类加载多次
         */
        //loader
//        Test16 loader2=new Test16("loader2");

        //loader已经加载了class文件,因此不会再加载
        Test16 loader2 = new Test16(loader, "loader2");
        loader2.setPath("E:\\idea_workspace\\JVMProject\\out\\production\\JVMProject\\jvm\\");

        Class<?> clazz2 = loader2.loadClass("jvm.Test2");
        System.out.println("class:" + clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        //class类型的输出完全一样,但是当ClassPath路径中没有class文件时,hashcode不一样(匿名空间的原因)
        System.out.println(object2);
        System.out.println();
    }
}
