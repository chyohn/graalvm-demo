package org.example.jnilib;

public class Main {

    static {
        System.loadLibrary("sharelib");
        System.loadLibrary("jnilib");
    }

    public static void main(String[] args) {
        System.out.println("-------------------start--------------------------");
        long isolateThread = MyMath.createIsolate();
        System.out.println("2 + 40 = " + MyMath.add(isolateThread, 2, 40));
        System.out.println("30 - 10 = " + MyMath.sub(isolateThread, 30, 10));
        System.out.println("-------------------end--------------------------");
    }
}
