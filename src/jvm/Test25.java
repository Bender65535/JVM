package jvm;

public class Test25 implements Runnable{
    private Thread thread;

    public Test25() {
        thread=new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader=this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(classLoader);

        //它的上下文加载器就是应用类加载器(并没有主动设置其上下文加载器,Launcher中自动设置当前线程为系统类加载器)
        System.out.println("class:"+classLoader.getClass());
        System.out.println("parent:"+classLoader.getParent().getClass());

    }

    public static void main(String[] args) {
        new Test25();
    }
}
