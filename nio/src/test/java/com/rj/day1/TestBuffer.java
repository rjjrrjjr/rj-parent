package com.rj.day1;

import java.nio.ByteBuffer;

import org.junit.Test;
/**
 * ByteBuffer.put(byte[])、ByteBuffer.get(byte[])、ByteBuffer.get()   会影响当前position左右移动
 * ByteBuffer.get(int)                                                不会影响当前position
 * ByteBuffer.rewind()                                                重置当前position、其他不变
 * ByteBuffer.flip()                                                  重置当前position、limit做相应变化
 * ByteBuffer.clear()                                                 重置position、limit、capacity
 */

/**
 * Created by 10064028 on 2018/2/12.
 */
public class TestBuffer {

    @Test
    public void test1(){

        String str = "sadffgh";

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        System.out.println("--------------------------allocate()------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.put(str.getBytes());
        System.out.println("-----------------------put-----------------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        System.out.println(byteBuffer.get(0));
        System.out.println(byteBuffer.get(1));
        System.out.println(byteBuffer.get(0));
        System.out.println(byteBuffer.get(1));
        System.out.println(new String(byteBuffer.array()));


        byteBuffer.flip();
        System.out.println("------------------------------flip---------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());


        byte[] dst = new byte[5];
        byteBuffer.get(dst);
        System.out.println(new String(dst, 0, dst.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.get(0));
        System.out.println(new String(new byte[]{byteBuffer.get()}));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        System.out.println("---------------------rewind--------------------------------");
        byteBuffer.rewind();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.get(new byte[2]);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(new String(byteBuffer.array()));

        byteBuffer.put("vvv".getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(new String(byteBuffer.array()));

        System.out.println("================================");

        byteBuffer.get();
        byteBuffer.get();
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        System.out.println("=======================");
        byteBuffer.get(new byte[2]);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.mark();
        byteBuffer.get();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(new String(byteBuffer.array()));
        byteBuffer.put("m".getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(new String(byteBuffer.array()));
        byteBuffer.reset();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(new String(byteBuffer.array()));
        System.out.println("=====================data==================");
        //判断缓冲区中是否还有剩余数据
        if(byteBuffer.hasRemaining()){

            //获取缓冲区中可以操作的数量
            System.out.println(byteBuffer.remaining());
        }
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(new String(byteBuffer.array()));

        System.out.println("-------------------------flip-----------------------");
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(new String(byteBuffer.array()));

        System.out.println(byteBuffer.isDirect());
        System.out.println("-------------------------clear------------------");
        byteBuffer.clear();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }

    @Test
    public void test2(){
        String str = "saddfgdhgj";
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        byteBuffer.put(str.getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("===================data=======");
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("==================put");
        byteBuffer.put("a".getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(new String(byteBuffer.array()));
    }
}
