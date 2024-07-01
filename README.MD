
# Description
A demo that JNI implementation that call function in another shared library.

the solution as below:
1. sharelib module: Use `native-image` to Build a shared library named `sharelib`. 
2. jnilib module: a JNI API implementation, call the function in the `sharelib`. and use `native-image` to Build the module, the output file named `jnilib`.
3. jni-client module: a example of call native function in `jnilib`.

# build and execute
```shell
cd graalvm-demo
mvn clean package -Dmaven.test.skip=true
cd bin && jni-client
```