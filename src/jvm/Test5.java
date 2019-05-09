package jvm;

import java.util.Random;

/**
 * 删了MyParent5.class后程序照样执行
 * 说明:
 * 当一个接口在初始化时,并不要求其父接口都完成了初始化
 *
 * 只有在真正使用到父接口的时候(如引用接口中所定义的常量时),才会初始化
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(MyChild.b);

    }
}
interface MyParent5{
    //接口中的常量都是公共静态final的
//    public static int a=5;

    public static Thread thread=new Thread(){
        {
            System.out.println("myparent5 invoked");
        }
    };

}
class MyChild implements MyParent5{
    //接口中的常量都是公共静态的
//    public static int b=6;
    public static int b=new Random().nextInt(2);//运行期生成,需要有class文件

}
