package com.yuler.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator1(new ConcreteComponent());
        component.operation();

    }
}

interface Component {
    void operation();
}

class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("拍照");
    }
}

abstract class Decorator implements Component {
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

class ConcreteDecorator1 extends Decorator {

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("add 美颜效果");
        component.operation();
    }
}

