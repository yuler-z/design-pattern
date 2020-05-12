package com.yuler.singleton;

public class HungrySingletonTest {
    public static void main(String[] args) {
//        HungrySingleton ins1 = HungrySingleton.getInstance();
//        HungrySingleton ins2 = HungrySingleton.getInstance();
//        System.out.println(ins1 == ins2);

        new Thread(() -> {
            HungrySingleton ins = HungrySingleton.getInstance();
            System.out.println(ins);
        }).start();

        new Thread(() -> {
            HungrySingleton ins = HungrySingleton.getInstance();
            System.out.println(ins);
        }).start();

    }
}

class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
