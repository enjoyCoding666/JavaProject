package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * 建立一个非阻塞的服务端
 */
public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException {
        int port=4396;
        //打个选择器
        Selector selector= Selector.open();
        //打开服务器套接字通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //服务器设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket=serverSocketChannel.socket();
        //表示监听地址
        InetSocketAddress inetSocketAddress=new InetSocketAddress(port);
        //绑定地址
        serverSocket.bind(inetSocketAddress);
        //注册选择器，相当于使用accept()
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器运行在"+port+"端口监听");

    }
}
