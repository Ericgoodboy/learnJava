package enum_;
/*
* 利用java的反射机制，可以在程序运行时分析类，在反射之前需要获得Class类对象，该类是反射的入口
* */


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class test1 {
public static void main(String args[]){
    Class<Position> enumClass =Position.class;
    String modifiers = Modifier.toString(enumClass.getModifiers());
    System.out.println("enum的修饰符:"+modifiers);
    System.out.println("enum的父类："+enumClass.getSuperclass());
    System.out.println("enum的自定义方法");
    Method[] mothods = enumClass.getDeclaredMethods();
    for (Method m : mothods){
        System.out.println(m);
    }

}
}
