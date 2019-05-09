package jvm;

public class Mycat {
    public Mycat() {
        System.out.println("MyCat is loaded by:"+this.getClass().getClassLoader());
    }
}
