package com.crayon2f.interfaces;

/**
 * Created by feiFan.gou on 2018/2/26 10:30.
 */
public interface PrivateMethod {

    private void privateFun() {
        System.out.println("interface also can defined private method !!");
    }

    default void defaultFun() {
        System.out.println("jdk8 defined default method !!");
    }
}
