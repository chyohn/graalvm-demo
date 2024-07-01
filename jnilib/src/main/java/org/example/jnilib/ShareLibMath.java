package org.example.jnilib;

import java.io.File;
import java.util.Collections;
import java.util.List;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.function.CFunction;
import org.graalvm.nativeimage.c.function.CFunction.Transition;
import org.graalvm.nativeimage.c.function.CLibrary;
import org.graalvm.nativeimage.c.type.CCharPointer;

@CLibrary(value = "sharelib")
@CContext(value = ShareLibHeaderDirectives.class)
public class ShareLibMath {

    @CFunction(value = "sub", transition = Transition.NO_TRANSITION)
    public static native int sub(long isolateThreadId, int a, int b);

    public static int subx(long isolateThreadId, int a, int b) {
        System.out.println("ShareLib client subt invoke native method sub");
        return sub(isolateThreadId, a, b);
    }
}

final class ShareLibHeaderDirectives implements CContext.Directives {
    static String filePath;
    static {
        File bin = new File("bin").getAbsoluteFile();
        filePath = bin.getAbsolutePath();
        System.out.println("share lib header path: " + filePath);
    }
    @Override
    public List<String> getOptions() {
        return Collections.singletonList("-I" + filePath);
    }

    @Override
    public List<String> getHeaderFiles() {
        return Collections.singletonList("\"" + filePath + "/sharelib.h" + "\"");
    }

}