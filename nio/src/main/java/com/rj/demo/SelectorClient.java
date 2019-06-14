package com.rj.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;


/**
 * Created by 10064028 on 2018/3/9.
 */
public class SelectorClient {

    public void client() throws IOException {
        //获取（客户端）通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 5656));
        //切换非阻塞
        socketChannel.configureBlocking(false);
        //发送数据到服务端
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            byteBuffer.put((new Date().toString() + "\n" + str).getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        socketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        new SelectorClient().client();
    }
}
