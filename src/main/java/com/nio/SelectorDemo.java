package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 创建一个非阻塞的服务器，向客户端返回当前的系统时间
 */
public class SelectorDemo {
    public static void main(String[] args) throws IOException {
         int ports[]= {  8000,8001,8002,8003,8004 } ;
         Selector selector=Selector.open();
         for(int port : ports)  {
             //打开服务器套接字通道
             ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
             //服务器配置设置为非阻塞
             serverSocketChannel.configureBlocking(false);
             ServerSocket serverSocket=serverSocketChannel.socket();
             InetSocketAddress inetSocketAddress=new InetSocketAddress(port);
             serverSocket.bind(inetSocketAddress);
             //注册选择器，相当于使用accept()方法接收
             serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT );
             System.out.println("服务器运行,在"+port+"端口监听");
         }

         int keysAdd;
         //选择一组键，相当的通道已为IO准备就绪
         while ( (keysAdd=selector.select())>0 )  {
             //取出全部生成的key
             Set<SelectionKey> selectionKeySet=selector.selectedKeys() ;
             Iterator<SelectionKey> iterator=selectionKeySet.iterator();
             //迭代全部的SelectionKey
             while (iterator.hasNext())  {
                 SelectionKey key=(SelectionKey) iterator.next();
                 //判断客户端是否已经连接上
                 if(key.isAcceptable())  {
                     //通过key获取channel
                     ServerSocketChannel serverSocketChannel=(ServerSocketChannel) key.channel();
                     SocketChannel socketChannel=serverSocketChannel.accept();
                     serverSocketChannel.configureBlocking(false);
                     ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
                     byteBuffer.put(( "当前时间为"+new Date() ).getBytes());
                     byteBuffer.flip();
                     socketChannel.write(byteBuffer);
                     socketChannel.close();

                 }
             }
             selectionKeySet.clear();
         }
    }

}
