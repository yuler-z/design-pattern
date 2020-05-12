package com.yuler.prototype;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;

public class PrototypeTest {
    public static void main(String[] args) {

    }
}

class BaseInfo implements Cloneable {
    private Integer part1;

    public Integer getPart1() {
        return part1;
    }

    public void setPart1(Integer part1) {
        this.part1 = part1;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return ((BaseInfo) super.clone());
    }
}

class Product implements Cloneable {
    private String producName;
    private String companyName;
    private BaseInfo baseinfo;

    public String getProducName() {
        return producName;
    }

    public void setProducName(String producName) {
        this.producName = producName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BaseInfo getBaseinfo() {
        return baseinfo;
    }

    public void setBaseinfo(BaseInfo baseinfo) {
        this.baseinfo = baseinfo;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        // deep copy
        // 处理 mutable object
        // v1 直接处理
        Product clone = ((Product) super.clone());
        BaseInfo info = this.baseinfo.clone();
        clone.setBaseinfo(info);
        //v2 序列化处理
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        try (ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream)) {
//            oos.writeObject(this);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//        try (ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream)) {
//            Product product = (Product) ois.readObject();
//            return product;
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        return clone;
    }
}
