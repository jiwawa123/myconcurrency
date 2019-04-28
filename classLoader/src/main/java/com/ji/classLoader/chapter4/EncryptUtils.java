package com.ji.classLoader.chapter4;/*
    user ji
    data 2019/3/19
    time 3:16 PM
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class EncryptUtils {
    public  static final byte factor = (byte) 0xff;

    private EncryptUtils() {
    }

    /*
    实现对一个文件进行相应的加密，然后放到另一个文件中
     */
    public static void encrypt(String source, String target) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(target) {
             }) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data ^ factor);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        encrypt("/Users/ji/IdeaProjects/app/bbbb","/Users/ji/IdeaProjects/app/dddd");

    }
}
