package com.rj.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;


/**
 * Selector会不断地轮询注册在其上的Channel，
 * 如果某个Channel上面发生了读或者写事件，
 * 这个Channel就会处于就绪状态，
 * 会被Selector轮询出来，
 * 然后通过SelectionKey可以获取就绪Channel的集合，
 * 进行后续I/O操作
 *
 * Selector允许一个线程处理多个Channel，只要一个线程负责Selector的轮询，就可以处理成千上万哥Channel，减少线程上下文切换
 *
 * Created by 10064028 on 2018/3/9.
 */
public class SelectorServer {

    public void server() throws IOException {
        //打开（服务器）通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //配置通道非阻塞
        serverSocketChannel.configureBlocking(false);
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(5656));
        //获取（选择器）Selector
        Selector selector = Selector.open();
        //将通道注册到选择器中，同时监听通道的‘连接’事件（客户端连接上即触发）
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("=========================server start========================");
        //轮询获取选择器上准备就绪的事件
        while (selector.select() > 0){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()){
                    //获取当‘前服务端通道’对应的‘客户端连接通道’
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    //将此‘客户端通道’注册到（选择器）Selector，同时监听通道的‘可读’事件（客户端向服务端发送数据的时候触发）
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if (selectionKey.isReadable()){
                    //获取当前‘监听事件’对应的‘客户端通道’
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //读取来自客户端的数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int len;
                    while ((len = socketChannel.read(byteBuffer)) > 0){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, len));
                        byteBuffer.clear();
                    }
                }
            }
            iterator.remove();
        }
    }

    public static void main(String[] args) throws IOException {
        new SelectorServer().server();
    }
}
