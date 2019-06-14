package com.alog;

/**
 * Created by 10064028 on 2017/12/28.
 */
public class Demo {
    public static void main(String[] args) {
        Exception exception = new Exception();

        if (exception instanceof Exception){
            System.out.println("exception instanceof Exception");
        }
    }
}
