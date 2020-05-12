package com.yuler.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 3. 静态内部类
 */
public class InnerClassSingletonTest {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
//        InnerClassSingleton ins1 = InnerClassSingleton.getInstance();
//        InnerClassSingleton ins2 = InnerClassSingleton.getInstance();
//        System.out.println(ins1 == ins2);
//        new Thread(()->{
//            InnerClassSingleton ins = InnerClassSingleton.getInstance();
//            System.out.println(ins);
//        }).start();
//
//        new Thread(()->{
//            InnerClassSingleton ins = InnerClassSingleton.getInstance();
//            System.out.println(ins);
//        }).start();
        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingleton ins1 = declaredConstructor.newInstance();

        InnerClassSingleton ins2 = InnerClassSingleton.getInstance();
        System.out.println(ins1 == ins2);
    }
}

class InnerClassSingleton {
    static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("单例模式");
        }

    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

}
