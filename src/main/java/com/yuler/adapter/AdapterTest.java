package com.yuler.adapter;

public class AdapterTest {
    public static void main(String[] args) {

        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);

        System.out.println(target.output5v());

    }
}

class Adaptee {

    public int output220v() {
        int i = 220;
        return i;
    }
}

interface Target {
    int output5v();
}

class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i = adaptee.output220v();
        // ... 处理
        i = 5;
        return i;
    }
}
