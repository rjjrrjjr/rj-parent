package com.rj.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.junit.Test;

/**
 * Created by 10064028 on 2018/2/12.
 */
public class TestChannel {

    @Test
    public void test1(){
        long startTime = System.currentTimeMillis();

        FileInputStream in = null;
        FileOutputStream out = null;

        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            in = new FileInputStream("E://image//aaa.PNG");
            out  = new FileOutputStream("E://image//bbb.PNG");

            //获取通道一：Java 针对支持通道的类提供了 getChannel() 方法
            inChannel = in.getChannel();
            outChannel = out.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (inChannel.read(byteBuffer) != -1){
                System.out.println(byteBuffer.position());
                System.out.println(byteBuffer.limit());
                System.out.println(byteBuffer.capacity());
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inChannel.close();
                outChannel.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("use time: " + (endTime - startTime));
    }

    @Test
    public void test2() throws IOException {

        //获取通道一：在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
        FileChannel inChannel = FileChannel.open(Paths.get("E://image//aaa.PNG"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E://bbb.PNG"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();
    }

    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E://image//aaa.PNG"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E://bbb.PNG"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        inChannel.transferTo(0, inChannel.size(), outChannel);
        //outChannel.transferFrom(inChannel, 0, inChannel.size());

        inChannel.close();
        outChannel.close();
    }

    @Test
    public void test4() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("E://image//aaa.txt", "r");
        //获取通道一：Java 针对支持通道的类提供了 getChannel() 方法
        FileChannel channel = randomAccessFile.getChannel();

        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        ByteBuffer[] bufs = {buf1, buf2};
        channel.read(bufs);

        for (ByteBuffer bf : bufs){
            bf.flip();
            System.out.println(new String(bf.array()));
            System.out.println("======================================");
        }

        new RandomAccessFile("E://bbb.txt", "rw").getChannel().write(bufs);
        channel.close();
    }

    @Test
    public void test5(){
        SortedMap<String, Charset> charsetSortedMap = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> entries = charsetSortedMap.entrySet();

        for (Map.Entry<String, Charset> entry : entries){
            System.out.println(entry.getKey() + "======================>" + entry.getValue());
        }

    }
}
