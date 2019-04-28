package com.ji.classLoader.chapter4;/*
    user ji
    data 2019/3/19
    time 3:09 PM
*/

public class SimpleEncrypt {
    private  static final String str = "Hello classLoader ";
    private  static final byte factor = (byte)0xff;
    public static void main(String[] args) {
        byte[] bytes = str.getBytes();
        byte[] encrypt = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            encrypt[i] = (byte)(bytes[i]^factor);
        }
        System.out.println(str);
        System.out.println(new String(encrypt));
        byte[] crypt = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            crypt[i] = (byte)(encrypt[i]^factor);
        }
        System.out.println(new String(crypt));

    }
}
