package com.serializationanddeserialization;

import java.io.Serializable;

public class Singleton implements Serializable {
    private volatile static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(System.identityHashCode(singleton1));
        System.out.println(System.identityHashCode(singleton2));
    }
    public Object readResolve(){
        return singleton;
    }
}
