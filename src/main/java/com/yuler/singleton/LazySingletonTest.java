package com.yuler.singleton;

/***
 *
 * 1. scynchronized
 * 2. double check
 * 3. 防止指令重排
 */

public class LazySingletonTest {
    public static void main(String[] args) {
//        LazySingleton ins1 = LazySingleton.getInstance();
//        LazySingleton ins2 = LazySingleton.getInstance();
//        System.out.println(ins1 == ins2);

        new Thread(() -> {
            LazySingleton ins = LazySingleton.getInstance();
            System.out.println(ins);
        }).start();

        new Thread(() -> {
            LazySingleton ins = LazySingleton.getInstance();
            System.out.println(ins);
        }).start();


    }
}

class LazySingleton {
    private static volatile LazySingleton instance;

    private LazySingleton() {

    }

    //
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}
