package com.yuler.adapter;

/**
 * org.framework.context.event.GenericApplicationListener
 */
public class AdapterTest2 {
    public static void main(String[] args) {
        // 类适配器
        // 类适配器知道了不该知道的函数，造成干扰
        // 污染接口， 不符合迪米特原则
        Adapter2 adapter = new Adapter2();
        adapter.output5v();
    }
}


class Adapter2 extends Adaptee implements Target {
    @Override
    public int output5v() {
        int i = output220v();
        // ....
        i = 5;
        return i;
    }
}
