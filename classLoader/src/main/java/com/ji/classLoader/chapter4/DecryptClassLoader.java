package com.ji.classLoader.chapter4;/*
    user ji
    data 2019/3/19
    time 3:36 PM
*/

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DecryptClassLoader extends ClassLoader {
    private final static String path = "";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File file = new File(path, classPath + ".class");
        if (!file.exists()) {
            throw new ClassNotFoundException(name + " 文件不存在");
        } else {
            byte[] classBytes = loadClassBytes(file);
            if (null == classBytes || classBytes.length == 0)
                throw new ClassNotFoundException("empty");
            return this.defineClass(name, classBytes, 0, classBytes.length);
        }
    }

    private byte[] loadClassBytes(File classFile) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(classFile)) {
            int len;
            while ((len = fis.read()) != -1) {
                baos.write(len^EncryptUtils.factor);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
