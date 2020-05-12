package com.yuler.factoryMethod;

/**
 * java.net.URLStreamHandlerFactory
 * java.xml.bind.JAXBContext.createMarshaller
 */


public class FactoryMethodTest {
    public static void main(String[] args) {

    }
}

// Product
interface Product {
    void method();
}

class Product1 implements Product {

    @Override
    public void method() {
        System.out.println("Product1.method");
    }
}

class Product2 implements Product {

    @Override
    public void method() {
        System.out.println("Product2.method");
    }
}

abstract class Application {
    abstract Product createProduct();

    Product createObject() {
        // ...
        return createProduct();
    }
}

class ConcreteApp1 extends Application {

    @Override
    Product createProduct() {
        // ...
        return new Product1();
    }
}

class ConcreteApp2 extends Application {

    @Override
    Product createProduct() {
        // ...
        return new Product2();
    }
}
