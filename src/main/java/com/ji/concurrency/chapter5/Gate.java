package com.ji.concurrency.chapter5;/*
    user ji
    data 2019/3/11
    time 10:14 PM
*/

/*
share resources

 */
public class Gate {
    private int count = 0;
    private  String name = "nobody";
    private  String address = "nowhere";

    public synchronized void pass(String name, String address) {
        count++;
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("count " + this.count + "  " + this.name + "  is not match " + this.address);
        }
    }

}
