package jvm;

public class Test13 {
    public static void main(String[] args) {
        ClassLoader loader =ClassLoader.getSystemClassLoader();

        System.out.println(loader);

        while(null!=loader){
            loader=loader.getParent();

            System.out.println(loader);
        }
    }
}
