package org.example.jnilib;

public class MyMath {

    // return a+b
    public static native int add(long isolateId, int a, int b);

    // return a-b
    public static  native int sub(long isolateThreadId, int a, int b);

    public static native long createIsolate();
}
