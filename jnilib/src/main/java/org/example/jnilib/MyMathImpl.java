package org.example.jnilib;

import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.word.Pointer;

public class MyMathImpl {

    @CEntryPoint(name = "Java_org_example_jnilib_MyMath_add")
    public static int add(Pointer jniEnv, Pointer clazz,
        @CEntryPoint.IsolateThreadContext long isolateId,
        int a, int b) {
        return a + b;
    }

    @CEntryPoint(name = "Java_org_example_jnilib_MyMath_sub")
    public static int sub(Pointer jniEnv, Pointer clazz,
        @CEntryPoint.IsolateThreadContext long isolateThreadId,
        int a, int b) {
        return ShareLibMath.subx(isolateThreadId, a, b);
    }

    @CEntryPoint(name = "Java_org_example_jnilib_MyMath_createIsolate", builtin = CEntryPoint.Builtin.CREATE_ISOLATE)
    public static native IsolateThread createIsolate();
}
