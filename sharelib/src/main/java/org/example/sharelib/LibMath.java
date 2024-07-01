package org.example.sharelib;

import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.c.function.CEntryPoint;

public class LibMath {

    @CEntryPoint(name = "sub")
    public static int sub(IsolateThread thread, int a, int b) {
        System.out.println("share lib execute sub express a-b");
        return a - b;
    }

    @CEntryPoint(name = "createIsolate", builtin = CEntryPoint.Builtin.CREATE_ISOLATE)
    public static native IsolateThread createIsolate();
}
