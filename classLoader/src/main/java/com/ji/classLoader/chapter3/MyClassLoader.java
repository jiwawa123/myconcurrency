package com.ji.classLoader.chapter3;/*
    user ji
    data 2019/3/19
    time 1:57 PM
*/
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
    private final static String dir_path = "/Users/ji/IdeaProjects/app/";
    private String dir = dir_path;

    private String classLoadName;

    public MyClassLoader(String classLoadName) {
        super();
        this.classLoadName = classLoadName;
    }

    public MyClassLoader(String classLoadName, ClassLoader parent) {
        super(parent);
        this.classLoadName = classLoadName;
    }

    public MyClassLoader() {
        super();
    }

    public String getClassLoadName() {
        return classLoadName;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    /*
     xxx.xxx.xxx.AAA
     xxx.xxx.xxx.class
     */
    @Override
    protected Class<?> findClass(String name)
            throws ClassNotFoundException {
        // 进行文件的替换
        String classPath = name.replace(".", "/");
        File classFile = new File(dir, classPath + ".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException(" the class " + name + " not found ");
        }
        byte[] classBytes = loadClassBytes(classFile);
        if (null == classBytes || classBytes.length == 0)
            throw new ClassNotFoundException(" the class " + name + " is empty ");
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] loadClassBytes(File classFile) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(classFile)) {
            byte[] buffer = new byte[1024];
            int len ;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer,0,len );
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
